package vn.edu.likelion.application;

import vn.edu.likelion.lession1.models.Bank;
import vn.edu.likelion.lession1.models.CurrentAccount;
import vn.edu.likelion.lession1.models.Customer;
import vn.edu.likelion.lession1.models.SavingsAccount;

public class Application {
    public static void main(String[] args) {
        Customer customer = new Customer("001", "Nhut", 5000);
        Bank bank = new Bank();

        SavingsAccount savingsAccount = new SavingsAccount(1000);

        customer.addSavingAccount(savingsAccount);

        bank.addAccount(savingsAccount);
        bank.addAccount(customer.getCurrentAccount());

        System.out.println("Current Account:");
        System.out.println("Initial Deposit: $" + customer.getCurrentAccount().getBalance());
        System.out.println("OverdraftLimit: $" + customer.getCurrentAccount().getOVERDRAFT_LIMIT());

        savingsAccount.deposit(100);
        customer.getCurrentAccount().deposit(500);
        savingsAccount.withdraw(150);

        System.out.println("Savings A/c and Current A/c.:");
        System.out.println("Account balance: " + savingsAccount.getBalance());
        System.out.println("Account balance: " + customer.getCurrentAccount().getBalance());

        bank.calculateAnnualInterest();

        System.out.println("After applying interest on Savings A/c for 1 year:");
        System.out.println("Savings A/c and Current A/c.:");
        System.out.println("Account balance: " + savingsAccount.getBalance());
        System.out.println("Account balance: " + customer.getCurrentAccount().getBalance());
    }
}
