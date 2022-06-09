package salary;

import java.util.Scanner;

public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String operation = args[0];

        if ("pay".equals(operation)) {
            calculatePay(args[1]);
        } else if ("basePays".equals(operation)) {
            sumOfBasePays();
        }

    }

    private static void sumOfBasePays() {
        puts("급여 총액: " + Employees.sumOfBasePays());
    }

    private static void calculatePay(String name) {
        double taxRate = getTaxRate();
        double pay;
        if (Employees.hourly(name)) {
            pay = Employees.calculateHourlyPayFor(name, taxRate);
        } else {
            pay = Employees.calculatePayFor(name, taxRate);
        }
        puts(describeResult(name, pay));
    }


    private static double getTaxRate() {
        System.out.print("세율을 입력하세요: ");
        return Double.parseDouble(SCANNER.nextLine());
    }

    private static String describeResult(String name, double pay) {
        return String.format("이름: %s, 급여: %f", name, pay);
    }

    private static void puts(String describeResult) {
        System.out.println(describeResult);
    }

}
