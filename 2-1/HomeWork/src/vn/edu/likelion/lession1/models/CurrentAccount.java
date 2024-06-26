package vn.edu.likelion.lession1.models;

public class CurrentAccount extends Account {
    private final double OVERDRAFT_LIMIT = 1000;

    public CurrentAccount(double initialDeposit) {
        super(initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + OVERDRAFT_LIMIT) {
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
    public void applyInterest() {
    }

    public double getOVERDRAFT_LIMIT() {
        return OVERDRAFT_LIMIT;
    }
}
