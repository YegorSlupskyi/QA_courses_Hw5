package HW2;
import java.util.Scanner;

public class Main {
    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        task1();
        System.out.println("____________________________");
        task2();
        System.out.println("____________________________");
        task3();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter base:");
        double base = scanner.nextDouble();

        System.out.println("Enter exponent:");
        double exponent = scanner.nextDouble();

        double power = Math.pow(base, exponent);

        System.out.println("Power=: " + power);
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter workHoursPerWeek:");
        double workHoursPerWeek = scanner.nextDouble();

        System.out.println("Enter rate:");
        double rate = scanner.nextDouble();

        System.out.println("Enter taxPercent:");
        double taxPercent = scanner.nextDouble();

        double wagePerMonthWithoutTaxes = (workHoursPerWeek * rate) * 4;
        double wagePerMonthWithTaxes = wagePerMonthWithoutTaxes * (1 - (taxPercent / 100));
        double wagePerYearWithoutTaxes = wagePerMonthWithoutTaxes * 12;
        double wagePerYearWithTaxes = wagePerMonthWithTaxes * 12;

        System.out.println("wagePerMonthWithoutTaxes = " + wagePerMonthWithoutTaxes + "$");
        System.out.println("wagePerMonthWithTaxes = " + wagePerMonthWithTaxes + "$");
        System.out.println("wagePerYearWithoutTaxes = " + wagePerYearWithoutTaxes + "$");
        System.out.println("wagePerYearWithTaxes = " + wagePerYearWithTaxes + "$");
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter workHoursPerWeek:");
        double workHoursPerWeek = scanner.nextDouble();

        System.out.println("Enter wagePerYearWithTaxes:");
        double wagePerYearWithTaxes = scanner.nextDouble();

        System.out.println("Enter taxPercent:");
        double taxPercent = scanner.nextDouble();

        double wagePerMonthWithTaxes = wagePerYearWithTaxes / 12;
        double wagePerMonthWithoutTaxes = (wagePerMonthWithTaxes * 100) / (100 - taxPercent);
        double wagePerWeekWithoutTaxes = wagePerMonthWithoutTaxes / 4;
        double rate = wagePerWeekWithoutTaxes / workHoursPerWeek;

        System.out.println("rate = " + rate + "$");
    }
}



