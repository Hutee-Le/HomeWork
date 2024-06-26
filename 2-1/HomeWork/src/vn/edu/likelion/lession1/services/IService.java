package vn.edu.likelion.lession1.services;

public interface IService {
    void deposit(double amount);
    void withdraw(double amount);
    double calculateInterest();
    double getBalance();
}
