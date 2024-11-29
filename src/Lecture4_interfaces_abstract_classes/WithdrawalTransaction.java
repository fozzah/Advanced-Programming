package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false;

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        if (ba.getBalance() >= getAmount()) {
            ba.withdraw(getAmount());
            System.out.println("Withdrawal of $" + getAmount() + " applied.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
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

