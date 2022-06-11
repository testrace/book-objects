package salary;

public class Employee {

    private String name;
    private double basePay;
    private boolean hourly;
    private int timeCard;

    public double calculatePay(double taxRate) {
        if (hourly) {
            return calculateHourlyPay(taxRate);
        }
        return calculateSalariedPay(taxRate);
    }

    public double monthlyBasePay() {
        if (hourly) {
            return 0;
        }
        return basePay;
    }

    private double calculateHourlyPay(double taxRate) {
        return (basePay * timeCard) - (basePay * timeCard) * taxRate;
    }

    private double calculateSalariedPay(double taxRate) {
        return basePay - (basePay * taxRate);
    }
}
