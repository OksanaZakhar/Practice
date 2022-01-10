import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankEntry {

    private String accountType;
    private String accountNumber;
    private String currency;
    private Date dateOfOperation;
    private String referenceWiring;
    private String operationDescription;
    private double incoming;
    private double expense;


    public BankEntry(String accountType, String accountNumber, String currency, Date dateOfOperation, String referenceWiring, String operationDescription, double incoming, double expense) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.dateOfOperation = dateOfOperation;
        this.referenceWiring = referenceWiring;
        this.operationDescription = operationDescription;
        this.incoming = incoming;
        this.expense = expense;
    }

    public static List<BankEntry> loadBankEntry(String path) {
        List<BankEntry> bankEntryList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.remove(0);
            for (String line : lines) {
                String[] fragments = line.split(",");
                if (fragments.length != 8) {
                    if (fragments.length == 9) {
                        if (fragments[6].contains("\"")) {
                            fragments[6] = String.join(".", fragments[6].replaceAll("\"", ""), fragments[7].replaceAll("\"", ""));
                            fragments[7] = fragments[8];
                        } else {
                            fragments[7] = String.join(".", fragments[7].replaceAll("\"", ""), fragments[8].replaceAll("\"", ""));
                        }
                    } else if (fragments.length == 10) {
                        fragments[6] = String.join(".", fragments[6].replaceAll("\"", ""), fragments[7].replaceAll("\"", ""));
                        fragments[7] = String.join(".", fragments[8].replaceAll("\"", ""), fragments[9].replaceAll("\"", ""));
                    } else {
                        System.out.println("Wrong line: " + line);
                        continue;
                    }
                }
                String dateFormat = "dd.MM.yyyy";
                bankEntryList.add(new BankEntry(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        (new SimpleDateFormat(dateFormat)).parse(fragments[3]),
                        fragments[4],
                        fragments[5],
                        Double.parseDouble(fragments[6]),
                        Double.parseDouble(fragments[7])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bankEntryList;
    }

    public String toString() {
        return accountType + " " +
                accountNumber + " " +
                currency + " " +
                (new SimpleDateFormat("dd.MM.yyyy")).format(dateOfOperation) + " " +
                referenceWiring + " " +
                operationDescription + " " +
                incoming + " " +
                expense;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public double getIncoming() {
        return incoming;
    }

    public double getExpense() {
        return expense;
    }


    public String getBreakdownOfCosts() {
        String str = getOperationDescription();
        str = str.substring(str.indexOf(" "), str.length() - 1);
        str = str.trim();
        str = str.substring(0, str.indexOf("   "));
        str = str.trim();
        str = str.substring(str.lastIndexOf("\\") + 1, str.length() - 1);
        str = str.substring(str.lastIndexOf("/") + 1, str.length() - 1);
        str = str.trim();
        return str;
    }
}
