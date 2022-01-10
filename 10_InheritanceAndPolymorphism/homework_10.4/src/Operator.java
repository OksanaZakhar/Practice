public class Operator implements Employee {
    private double bet;
    private Company company;

    public Operator(Company company) {
        this.company = company;
        bet = Math.round(Math.random() * (30000.0 - 25000.0) + 25000.0);
    }

    @Override
    public double getMonthSalary() {
        return bet;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }
}
