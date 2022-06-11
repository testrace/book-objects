package salary;

public class SalariedEmployee extends Employee {

    protected SalariedEmployee(String name, double basePay) {
        super(name, basePay);
    }

    @Override
    public double calculatePay(double taxRate) {
        return getBasePay() - (getBasePay() * taxRate);
    }

    @Override
    public double monthlyBasePay() {
        return getBasePay();
    }
}
