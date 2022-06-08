package salary;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] EMPLOYEES = {"직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F"};
    private static final double[] BASE_PAYS = {400, 300, 250, 1, 1, 1.5};
    private static final boolean[] HOURLYS = {false, false, false, true, true, true};
    private static final int[] TIME_CARDS = {0, 0, 0, 120, 120, 120};

    public static void main(String[] args) {
        String operation = args[0];

        if ("pay".equals(operation)) {
            calculatePay(args[1]);
        } else if ("basePays".equals(operation)) {
            sumOfBasePays();
        }

    }

    private static void calculatePay(String name) {
        double taxRate = getTaxRate();
        double pay = calculatePayFor(name, taxRate);
        puts(describeResult(name, pay));
    }

    private static void sumOfBasePays() {
        double result = Arrays.stream(BASE_PAYS).sum();
        puts("급여 총액: " + result);
    }

    private static double getTaxRate() {
        System.out.print("세율을 입력하세요: ");
        return Double.parseDouble(SCANNER.nextLine());
    }

    private static double calculatePayFor(String name, double taxRate) {
        int index = Arrays.asList(EMPLOYEES).indexOf(name);
        double basePay = BASE_PAYS[index];
        return (basePay - (basePay * taxRate));
    }

    private static String describeResult(String name, double pay) {
        return String.format("이름: %s, 급여: %f", name, pay);
    }

    private static void puts(String describeResult) {
        System.out.println(describeResult);
    }

}
