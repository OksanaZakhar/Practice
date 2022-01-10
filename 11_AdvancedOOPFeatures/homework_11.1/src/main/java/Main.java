import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "11_AdvancedOOPFeatures/homework_11.1/data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
        for (Employee employee : staff) {
            System.out.println(employee);
        }

    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, ((o1, o2) -> {
            if (o1.getSalary().compareTo(o2.getSalary()) == 0) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        }));

        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
    }
}