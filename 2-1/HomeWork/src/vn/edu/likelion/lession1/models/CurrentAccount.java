package vn.edu.likelion.lession1.models;

import vn.edu.likelion.lession1.services.IService;

public class CurrentAccount extends Account implements IService {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(double initialDeposit) {
        this.balance = initialDeposit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + OVERDRAFT_LIMIT >= amount) {
            balance -= amount;
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
