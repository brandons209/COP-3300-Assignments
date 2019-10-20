package silva_p2;

public class SavingsAccount {
    private static double annualInterestRate = 0.05;
    private double savingsBalance;

    public SavingsAccount(double balance) {
        this.savingsBalance = balance;
    }

    public void calculateMonthlyInterest() {
        this.savingsBalance = this.savingsBalance + (this.savingsBalance * annualInterestRate) / 12;
    }

    public double getBalance() {
        return this.savingsBalance;
    }

    public static void modifyInterestRate(double rate) {
        annualInterestRate = rate;
    }

}
