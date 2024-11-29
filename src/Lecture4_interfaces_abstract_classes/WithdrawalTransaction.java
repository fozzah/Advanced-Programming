package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false;

    public WithdrawalTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    // Updated WithdrawalTransaction
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < getAmount()) {
            throw new InsufficientFundsException("Not enough funds for withdrawal.");
        }
        ba.withdraw(getAmount());
        System.out.println("Withdrawal of $" + getAmount() + " applied.");
    }

    // Overloaded apply() with exception handling
    public void apply(BankAccount ba, boolean allowPartial) {
        try {
            if (ba.getBalance() >= getAmount()) {
                ba.withdraw(getAmount());
            } else if (allowPartial && ba.getBalance() > 0) {
                double partial = ba.getBalance();
                ba.withdraw(partial);
                System.out.println("Partial withdrawal of $" + partial + " applied.");
            } else {
                throw new InsufficientFundsException("Not enough funds for withdrawal.");
            }
        } catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
        }
    }
    /*
   Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
    */
    public boolean reverse(BankAccount ba) {
        if (!reversed) {
            ba.deposit(getAmount());
            reversed = true;
            System.out.println("Withdrawal reversed.");
            return true;
        }
        return false;
    }
}

