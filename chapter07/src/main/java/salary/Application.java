package salary;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Employee> EMPLOYEES;

    static {
        EMPLOYEES = Arrays.asList(
            new SalariedEmployee("직원A", 400),
            new SalariedEmployee("직원B", 300),
            new SalariedEmployee("직원B", 300),
            new HourlyEmployee("아르바이트D", 1, 120),
            new HourlyEmployee("아르바이트E", 1, 120),
            new HourlyEmployee("아르바이트F", 1, 120)
        );
    }

    public static void main(String[] args) {
        String operation = args[0];

        if ("pay".equals(operation)) {
            calculatePay(args[1]);
        } else if ("basePays".equals(operation)) {
            sumOfBasePays();
        }

    }

    private static void sumOfBasePays() {
        double result = EMPLOYEES.stream()
            .mapToDouble(Employee::monthlyBasePay)
            .sum();
        puts("급여 총액: " + result);
    }

    private static void calculatePay(String name) {
        Employee employee = EMPLOYEES.stream()
            .filter(it -> it.areYou(name))
            .findFirst()
            .orElseThrow(NoSuchElementException::new);

        double pay = employee.calculatePay(getTaxRate());

        puts("급여: " + pay);

    }


    private static double getTaxRate() {
        System.out.print("세율을 입력하세요: ");
        return Double.parseDouble(SCANNER.nextLine());
    }

    private static void puts(String describeResult) {
        System.out.println(describeResult);
    }

}
