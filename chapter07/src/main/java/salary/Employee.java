package salary;

public abstract class Employee {

    private String name;
    private double basePay;

    protected Employee(String name, double basePay) {
        this.name = name;
        this.basePay = basePay;
    }

    public abstract double calculatePay(double taxRate);

    public abstract double monthlyBasePay();

    public boolean areYou(String name) {
        return name.equals(this.name);
    }

    public String getName() {
        return name;
    }

    public double getBasePay() {
        return basePay;
    }
}
