public class Main {
    public static void main(String args[]) {
        BankAccount bankAccount = new BankAccount();
        BankAccount bankAccount1 = new BankAccount();
        bankAccount.put(1200.0);
        bankAccount.send(bankAccount1, 100.0);
        System.out.println("Отправитель " + bankAccount.getAmount());
        System.out.println("Получатель " + bankAccount1.getAmount());

        CardAccount cardAccount = new CardAccount();
        CardAccount cardAccount1 = new CardAccount();
        cardAccount.put(2000);
        cardAccount1.put(10000);
        cardAccount1.send(cardAccount, 500);
        System.out.println("Отправитель с учетом комиссии " + cardAccount1.getAmount() + System.lineSeparator() + "Получатель " + cardAccount.getAmount());

        DepositAccount depositAccount = new DepositAccount();
        cardAccount.send(depositAccount, 200);    //с карты на депозит
        System.out.println("Депозит " + depositAccount.getAmount());

    }
}
