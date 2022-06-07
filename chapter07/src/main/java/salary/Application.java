package salary;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] EMPLOYEES = {"직원A", "직원B", "직원C"};
    private static int[] basePays = {400, 300, 250};

    public static void main(String[] args) {

        String name = args[0];

        double taxRate = getTaxRate();
        int pay = calculatePayFor(name, taxRate);
        puts(describeResult(name, pay));
    }

    private static double getTaxRate() {
        System.out.println("세율을 입력하세요:");
        return Double.parseDouble(SCANNER.nextLine());
    }

    private static int calculatePayFor(String name, double taxRate) {
        int index = Arrays.asList(EMPLOYEES).indexOf(name);
        int basePay = basePays[index];
        return basePay - (basePay * (int)taxRate);
    }

    private static String describeResult(String name, long pay) {
        return null;
    }

    private static void puts(String describeResult) {

    }

}
