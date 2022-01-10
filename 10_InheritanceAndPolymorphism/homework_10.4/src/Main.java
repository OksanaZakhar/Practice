import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            employeeList.add(new Operator(company));
        }
        for (int i = 0; i < 80; i++) {
            Manager manager = new Manager(company);
            employeeList.add(manager);
            company.totalSalesCompany = company.totalSalesCompany + manager.getSales();
        }
        for (int i = 0; i < 10; i++) {
            employeeList.add(new TopManager(company));
        }

        company.hireAll(employeeList);

        System.out.println("Доход компании " + company.getIncome());

        employeeList = company.getTopSalaryStaff(15);
        for (Employee employee : employeeList) {
            String clasS = employee.getClass().toString();
            System.out.print(clasS.substring(clasS.indexOf(" ") + 1, clasS.length()) + " - ");
            System.out.println(employee.getMonthSalary());
        }

        System.out.println();
        employeeList = company.getLowestSalaryStaff(10);
        for (Employee employee : employeeList) {
            String clasS = employee.getClass().toString();
            System.out.print(clasS.substring(clasS.indexOf(" ") + 1, clasS.length()) + " - ");
            System.out.println(employee.getMonthSalary());
        }

        System.out.println();

        employeeList = company.getList();
        System.out.println("Количество сотрудников до сокращения " + employeeList.size());

        while (company.getList().size() > 135) {
            company.fire(employeeList.get((int) Math.round(Math.random() * 269)));
        }
        System.out.println("Количество сотрудников после сокращения " + company.getList().size());

        System.out.println("Доход компании " + company.getIncome());

        employeeList = company.getTopSalaryStaff(15);
        for (Employee employee : employeeList) {
            String clasS = employee.getClass().toString();
            System.out.print(clasS.substring(clasS.indexOf(" ") + 1, clasS.length()) + " - ");
            System.out.println(employee.getMonthSalary());
        }

        System.out.println();
        employeeList = company.getLowestSalaryStaff(10);
        for (Employee employee : employeeList) {
            String clasS = employee.getClass().toString();
            System.out.print(clasS.substring(clasS.indexOf(" ") + 1, clasS.length()) + " - ");
            System.out.println(employee.getMonthSalary());
        }


    }
}
