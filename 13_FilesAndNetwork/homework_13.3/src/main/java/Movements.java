import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Movements {
    public List<BankEntry> bankEntries = new ArrayList<>();

    public Movements(String pathMovementsCsv) {
        bankEntries = BankEntry.loadBankEntry(pathMovementsCsv);
        HashSet<String> breakdownOfCosts = new HashSet<>();
        for (BankEntry bankEntry : bankEntries) {
            breakdownOfCosts.add(bankEntry.getBreakdownOfCosts());
        }
        System.out.println("Сумма расходов: " + getExpenseSum() + "  руб");
        System.out.println("Сумма доходов: " + getIncomeSum() + "  руб");
        System.out.println("Суммы расходов по организациям:");
        for (String br : breakdownOfCosts) {
            double sum = 0;
            for (BankEntry bankEntry : bankEntries) {
                if (bankEntry.getOperationDescription().contains(br)) {
                    sum = sum + bankEntry.getExpense();
                }
            }
            System.out.println(br + " - " + sum);

        }
    }

    public double getExpenseSum() {
        double sum = 0;
        for (BankEntry bankEntry : bankEntries) {
            sum = sum + bankEntry.getExpense();
        }
        return sum;
    }

    public double getIncomeSum() {
        double sum = 0;
        for (BankEntry bankEntry : bankEntries) {
            sum = sum + bankEntry.getIncoming();
        }
        return sum;
    }
}
