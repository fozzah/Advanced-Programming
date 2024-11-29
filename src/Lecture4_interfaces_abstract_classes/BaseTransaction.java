package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;
import java.util.UUID;

public class BaseTransaction implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Constructor initializes the transaction details.
     *
     * @param amount Transaction amount.
     * @param date   Transaction date.
     */
    public BaseTransaction(double amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        this.transactionID = date.getTimeInMillis() + "-" + UUID.randomUUID().toString();
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: $" + amount);
    }
    public void apply(BankAccount ba) throws InsufficientFundsException {
        System.out.println("Applying base transaction logic...");
        // Default behavior for transactions.
        ba.deposit(amount); // Example: Default action as a deposit.
        System.out.println("Applied base transaction of $" + amount);
    }
}
