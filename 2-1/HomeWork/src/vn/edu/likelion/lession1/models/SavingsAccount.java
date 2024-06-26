package vn.edu.likelion.lession1.models;

import vn.edu.likelion.lession1.services.IService;

public class SavingsAccount extends Account implements IService {
    private static final double INTEREST_RATE = 1.25 / 100;

    public SavingsAccount(double initialDeposit) {
        this.balance = initialDeposit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds for withdrawal");
        }
    }

    @Override
    public double calculateInterest() {
        balance += balance * INTEREST_RATE;
        return balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
