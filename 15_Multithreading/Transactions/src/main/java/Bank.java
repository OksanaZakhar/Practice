import java.util.*;

public class Bank {
    private static Map<String, Account> accounts = new HashMap<>();
    private static final Random random = new Random();
    private List<String> keys = new ArrayList<>();
    public static int countAccount = 10;


    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Bank() {
        for (int j = 1; j <= countAccount; j++) {
            String key = Integer.toString(j * (int) (Math.random() * 100000));
            keys.add(key);
            Account account = new Account((int) (Math.random() * 1000000), key);
            accounts.put(key, account);

        }
        Bank bank = new Bank(accounts);
    }


    public static synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }


    public List<String> getKeys() {
        return keys;
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        System.out.println("Транзакция " + " Списание со счета №: " + fromAccountNum +
                " , баланс  - " + getBalance(fromAccountNum) + System.lineSeparator() +
                "              " + " Перевод на счет №: " + toAccountNum +
                " , баланс  - " + getBalance(toAccountNum) + System.lineSeparator() +
                "               Сумма - " + amount);
        if (accounts.get(fromAccountNum).getMoney() < amount) {
            System.out.println("Недостаточно средств для списания!");

        } else {
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
        }
        try {
            if (amount > 50000) {
                while (isFraud(fromAccountNum, toAccountNum, amount)) {
                    System.out.println();
                    System.out.println("Счета " + fromAccountNum + " и " + toAccountNum + " заблокированы для проверки ");
                    System.out.println();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Результат транзакции " + fromAccountNum + " -> " + toAccountNum + "  Остатки на счетах: " +
                "Отправитель - № счета " + fromAccountNum + " , баланс  - " + getBalance(fromAccountNum) + System.lineSeparator() +
                "                Получатель - № счета " + toAccountNum + " , баланс  - " + getBalance(toAccountNum));
    }

    public void transferMoney(String fromAccountNum, String toAccountNum, long amount) {
        int fromId = Integer.valueOf(fromAccountNum);
        int toId = Integer.valueOf(toAccountNum);
        if (fromId < toId) {
            synchronized (accounts.get(fromAccountNum)) {
                synchronized (accounts.get(toAccountNum)) {
                    transfer(fromAccountNum, toAccountNum, amount);
                }
            }
        } else if ((fromId > toId)) {
            synchronized (accounts.get(toAccountNum)) {
                synchronized (accounts.get(fromAccountNum)) {
                    transfer(fromAccountNum, toAccountNum, amount);
                }
            }
        } else {
            System.out.println("Попытка перевода денег с счета " + accounts.get(toAccountNum).getAccNumber() + " на тот же счет " + accounts.get(fromAccountNum).getAccNumber());
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long k = 0;
        for (Map.Entry<String, Account> a : accounts.entrySet()) {
            k = k + a.getValue().getMoney();
        }
        return k;
    }


}
