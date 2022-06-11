package salary;

public class HourlyEmployee extends Employee {

    private final int timeCard;

    protected HourlyEmployee(String name, double basePay, int timeCard) {
        super(name, basePay);
        this.timeCard = timeCard;
    }

    @Override
    public double calculatePay(double taxRate) {
        return (getBasePay() * timeCard) - (getBasePay() * timeCard) * taxRate;
    }

    @Override
    public double monthlyBasePay() {
        return 0;
    }
}
