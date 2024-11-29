package Lecture4_interfaces_abstract_classes;

public class BankAccount {
    private double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited $" + amount);
        System.out.println("New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be greater than zero.");
            return;
        }
        balance -= amount;
        System.out.println("Successfully Withdrew $" + amount);
        System.out.println("New balance: $" + balance);
    }
}
