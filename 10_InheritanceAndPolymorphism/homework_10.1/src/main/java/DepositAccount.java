import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    protected LocalDate lastIncome; //можно и  private

    public void take(double amountToTake) {
        LocalDate now = LocalDate.now();
        if (amountToTake < accountBalance && lastIncome.until(now, ChronoUnit.MONTHS) >= 1) {
            accountBalance = accountBalance - amountToTake;
            lastIncome = now;
        }

    }

}
