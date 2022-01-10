public class TopManager implements Employee {
    private double bet;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
        bet = Math.round(Math.random() * (60000.0 - 50000.0) + 50000.0);
    }

    @Override
    public double getMonthSalary() {
        return (!company.equals(null) && company.getIncome() > 10000000) ? (2.5 * bet) : bet;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }
}
