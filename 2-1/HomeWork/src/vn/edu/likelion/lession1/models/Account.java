package vn.edu.likelion.lession1.models;

import vn.edu.likelion.lession1.services.IService;

abstract class Account implements IService {
    protected double balance;

    public Account(double initialDeposit) {
        this.balance = initialDeposit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public void applyInterest() {
    }
}
