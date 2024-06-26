package vn.edu.likelion.lession1.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerID;
    private String customerName;
    private CurrentAccount currentAccount;
    private List<SavingsAccount> savingsAccounts;

    public Customer(String customerID, String customerName, double balance) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.currentAccount = new CurrentAccount(balance);
        this.savingsAccounts = new ArrayList<>();
    }

    public void addSavingAccount(SavingsAccount account){
        savingsAccounts.add(account);
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }
}
