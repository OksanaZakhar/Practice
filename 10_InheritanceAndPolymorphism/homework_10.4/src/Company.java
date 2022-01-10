import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company implements Comparator<Employee> {

    public List<Employee> list = new ArrayList<>();
    public double totalSalesCompany = 1000000;

    public Company() {
    }

    public void hire(Employee employee) {
        list.add(employee);
        employee.setCompany(this);
    }

    public void hireAll(List<Employee> employees) {
        for (Employee employee : employees) {
            hire(employee);
        }
    }

    public List<Employee> getList() {
        return new ArrayList<>(list);
    }

    public void fire(Employee employee) {
        list.remove(employee);
        employee.setCompany(null);
    }

    public double getIncome() {
        return totalSalesCompany;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count < 0 || count >= list.size()) {
            return new ArrayList<>();
        }
        list.sort(this);
        List<Employee> listTop = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            listTop.add(list.get(i));
        }
        return listTop;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count < 0 || count >= list.size()) {
            return new ArrayList<>();
        }
        list.sort(this);
        List<Employee> listLowest = new ArrayList<>();
        for (int i = list.size() - 1; i >= list.size() - count; i--) {
            listLowest.add(list.get(i));
        }
        return listLowest;
    }


    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return 1;
        }
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
            return -1;
        }
        return 0;
        // return Double.compare(o1.getMonthSalary(), o2.getMonthSalary());
    }


}
