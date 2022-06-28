package salary;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Employees {

    private static final String[] EMPLOYEES = {"직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F"};
    private static final double[] BASE_PAYS = {400, 300, 250, 1, 1, 1.5};
    private static final boolean[] HOURLYS = {false, false, false, true, true, true};
    private static final int[] TIME_CARDS = {0, 0, 0, 120, 120, 120};


    public static boolean hourly(String name) {
        return HOURLYS[Arrays.asList(EMPLOYEES).indexOf(name)];
    }

    public static double sumOfBasePays() {
        return IntStream.range(0, EMPLOYEES.length)
            .filter(i -> !hourly(EMPLOYEES[i]))
            .mapToDouble(i -> BASE_PAYS[i])
            .sum();

    }

    public static double calculatePayFor(String name, double taxRate) {
        int index = Arrays.asList(EMPLOYEES).indexOf(name);
        double basePay = BASE_PAYS[index];
        return (basePay - (basePay * taxRate));
    }

    public static double calculateHourlyPayFor(String name, double taxRate) {
        int index = Arrays.asList(EMPLOYEES).indexOf(name);
        double basePay = BASE_PAYS[index] * TIME_CARDS[index];
        return (basePay - (basePay * taxRate));
    }
}
