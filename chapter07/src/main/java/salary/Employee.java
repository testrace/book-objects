package salary;

public class Employee {

    private String name;
    private double basePay;
    private boolean hourly;
    private int timeCard;

    public Employee(String name, double basePay, boolean hourly, int timeCard) {
        this.name = name;
        this.basePay = basePay;
        this.hourly = hourly;
        this.timeCard = timeCard;
    }

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

    public boolean areYou(String name) {
        return name.equals(this.name);
    }
}
