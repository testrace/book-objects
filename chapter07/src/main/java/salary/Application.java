package salary;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] EMPLOYEES = {"직원A", "직원B", "직원C"};
    private static int[] basePays = {400, 300, 250};

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
        int pay = calculatePayFor(name, taxRate);
        puts(describeResult(name, pay));
    }

    private static void sumOfBasePays() {
        int result = Arrays.stream(basePays).sum();
        puts("급여 총액: " + result);
    }

    private static double getTaxRate() {
        System.out.print("세율을 입력하세요: ");
        return Double.parseDouble(SCANNER.nextLine());
    }

    private static int calculatePayFor(String name, double taxRate) {
        int index = Arrays.asList(EMPLOYEES).indexOf(name);
        int basePay = basePays[index];
        return (int)(basePay - (basePay * taxRate));
    }

    private static String describeResult(String name, long pay) {
        return String.format("이름: %s, 급여: %d", name, pay);
    }

    private static void puts(String describeResult) {
        System.out.println(describeResult);
    }

}
