package vn.edu.likelion.lession1.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void calculateAnnualInterest(){
        for (Account account: accounts) {
            account.applyInterest();
        }
    }
}
