import java.util.List;


public class Main {
    static Bank bank = new Bank();

    public static void main(String[] args) {
        System.out.println("Общая сумма по счетам - " + bank.getSumAllAccounts());

        List<String> keys = bank.getKeys();

        for (int i = 0; i < 4; i++) {

            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    long amount = (long) (Math.random() * 80000);
                    String fromAccountNum = keys.get((int) (Math.random() * Bank.countAccount));
                    String toAccountNum = keys.get((int) (Math.random() * Bank.countAccount));
                    bank.transferMoney(fromAccountNum, toAccountNum, amount);
                }
            }).start();
        }

    }
}
