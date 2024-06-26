package vn.edu.likelion.lession1.models;

public class SavingsAccount extends Account  {
    private final double INTEREST_RATE = 1.25;

    public SavingsAccount(double initialDeposit) {
        super(initialDeposit);
    }

    @Override
    public double calculateInterest() {
        return balance * (INTEREST_RATE / 100);
    }

    @Override
    public void applyInterest() {
        balance += calculateInterest();
    }
}
