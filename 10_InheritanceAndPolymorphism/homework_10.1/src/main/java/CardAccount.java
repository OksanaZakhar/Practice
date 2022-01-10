public class CardAccount extends BankAccount {

    private double interestRate = 1.0;

    public void take(double amountToTake) {
        if (amountToTake < accountBalance) {
            accountBalance = accountBalance - amountToTake * (1 + interestRate / 100);
        }

    }
}
