public abstract class Client {
    protected double accountBalance = 0.0;

    public double getAmount() {
        return accountBalance;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0.0) {
            accountBalance = accountBalance + amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake < accountBalance) {
            accountBalance = accountBalance - amountToTake;
        }
    }

    public abstract String conditions();

}
