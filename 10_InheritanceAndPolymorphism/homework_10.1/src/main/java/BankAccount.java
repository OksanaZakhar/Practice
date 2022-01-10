public class BankAccount {
    protected double accountBalance = 0.0;
    protected boolean possibility = false;

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
            possibility = true;
        }
    }

    public boolean send(BankAccount receiver, double amount) {
        if (!receiver.equals(null) && amount < accountBalance) {
            take(amount);
            receiver.put(amount);
            System.out.println("Операция прошла успешно!");
        } else {
            System.out.println("Невозможно провести перевод, проверьте данные");
        }
        return possibility;
    }
}
