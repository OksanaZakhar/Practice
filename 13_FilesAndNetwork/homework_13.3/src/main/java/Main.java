public class Main {
    public static final String BANK_TXT = "13_FilesAndNetwork/homework_13.3/src/test/resources/movementList.csv";
    public static final String BANK_TXT2 = "13_FilesAndNetwork/homework_13.3/src/test/resources/movementListFloat.csv";
    public static final String BANK_TXT3 = "13_FilesAndNetwork/homework_13.3/src/test/resources/movementListInteger.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(BANK_TXT);
        System.out.println();
        Movements movements2 = new Movements(BANK_TXT2);
        System.out.println();
        Movements movements3 = new Movements(BANK_TXT3);


    }
}
