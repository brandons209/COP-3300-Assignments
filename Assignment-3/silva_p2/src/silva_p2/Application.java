package silva_p2;

public class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);

        SavingsAccount.modifyInterestRate(0.04);
        System.out.printf("Starting Balances:\nBalance 1: %.4f\nBalance 2: %.4f\n\n", saver1.getBalance(), saver2.getBalance());
        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("Month %d:\nBalance 1: %.4f\nBalance 2: %.4f\n\n", i+1, saver1.getBalance(), saver2.getBalance());
        }

        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("New interest rate 0.05 next month:\nBalance 1: %.4f\nBalance 2: %.4f\n\n", saver1.getBalance(), saver2.getBalance());
    }
}
