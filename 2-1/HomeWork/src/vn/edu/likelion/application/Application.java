package vn.edu.likelion.application;

import vn.edu.likelion.lession1.models.Account;
import vn.edu.likelion.lession1.models.CurrentAccount;
import vn.edu.likelion.lession1.models.SavingsAccount;
import vn.edu.likelion.lession2.model.Manager;
import vn.edu.likelion.lession2.model.Programmer;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // lession 01
        System.out.println("*--------------------------------------------------------------------*");
        List<Account> accounts = new ArrayList<>();

        SavingsAccount savingsAccount = new SavingsAccount(1000.0);
        CurrentAccount currentAccount = new CurrentAccount(5000.0);

        accounts.add(savingsAccount);
        accounts.add(currentAccount);

        savingsAccount.deposit(100.0);
        currentAccount.deposit(500.0);

        savingsAccount.withdraw(150.0);

        for (Account account : accounts) {
            System.out.println(account.getClass().getSimpleName() + " balance: " + account.getBalance());
        }

        savingsAccount.calculateInterest();

        for (Account account : accounts) {
            System.out.println(account.getClass().getSimpleName() + " balance after interest: " + account.getBalance());
        }
        System.out.println("*--------------------------------------------------------------------*");
        // lession 02
        Manager manager = new Manager("Corona Cadogan", 6000, 1000);
        manager.displayInfo();

        System.out.println("----------------------------------");

        Programmer programmer = new Programmer("Antal Nuka", 5000, 20, 25);
        programmer.displayInfo();

    }
}
