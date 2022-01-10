public class Manager implements Employee {
    private double bet;
    private double bonus = 0.05;
    public double sales;
    private Company company;


    public Manager(Company company) {
        this.company = company;
        sales = Math.round(Math.random() * 25000.0 + 115000.0);
        bet = Math.round(Math.random() * (40000.0 - 30000.0) + 30000.0);
    }

    @Override
    public double getMonthSalary() {
        return bet + bonus * getSales();
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    public double getSales() {
        return sales;
    }
}
