package HW3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println("____________________________");

        task2();
        System.out.println("____________________________");

        task3();
        System.out.println("____________________________");
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a real number");
        double number = scanner.nextDouble();

        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

        if (number <= 0 || number % 1 != 0) {
            System.out.println("The number is not natural");
        } else {
            if (number == 1) {
                System.out.println("One is neither prime nor composite");
            } else {

                boolean isPrime = true;

                for (int factor = 2; factor < number; factor++) {
                    if ((number % factor) == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime == false) {
                    System.out.println("The number is composite");
                } else {
                    System.out.println("The number is prime");
                }
            }
        }
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the product price per unit");
        double productPricePerUnit = scanner.nextDouble();
        System.out.println(productPricePerUnit + "$");

        if (productPricePerUnit <= 0) {
            System.out.println("The price must be positive");
            return;
        }


        System.out.println("Enter the amount");
        double productAmountToBuy = scanner.nextDouble();

        if (productAmountToBuy < 1 || productAmountToBuy % 1 != 0) {
            System.out.println("The amount cannot be non-positive or float");
            return;
        }

        if (productAmountToBuy > 10 && productAmountToBuy <= 20) {
            productPricePerUnit *= (1 - 0.05);
        } else if (productAmountToBuy > 20 && productAmountToBuy <= 30) {
            productPricePerUnit *= (1 - 0.1);
        } else if (productAmountToBuy > 30 && productAmountToBuy <= 80) {
            productPricePerUnit *= (1 - 0.12 - 0.004 * Math.floor((productAmountToBuy - 30) / 10));
        } else if (productAmountToBuy > 80) {
            productPricePerUnit *= (1 - 0.13);
        }
        System.out.println(productPricePerUnit + "$");
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the month number [1-12]");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("The month number must be in range of [1-12]");
            return;
        }

        System.out.println("Enter the rate");
        double rate = scanner.nextDouble();
        if (rate <= 0) {
            System.out.println("The rate must be positive");
            return;
        }
        System.out.println(rate + "$");

        System.out.println("Enter the tax percent");
        double taxPercent = scanner.nextDouble();
        if (taxPercent <= 0 || taxPercent >= 100) {
            System.out.println("The tax percent must be in range of [1-100)");
            return;
        }
        System.out.println(taxPercent + "%");

        int daysInMonth;

        switch (monthNumber) {
            case 2 -> daysInMonth = 28;
            case 1, 3, 5, 7, 8, 10, 12 -> daysInMonth = 31;
            default -> daysInMonth = 30;
        }

        int workDaysInMonth = daysInMonth - 8;
        int workHoursPerWeek = 8;

        double wageWithoutTaxes = workDaysInMonth * workHoursPerWeek * rate;
        double wageWithTaxes = wageWithoutTaxes * (1 - taxPercent / 100);

        System.out.println("Wage Without Taxes= " + wageWithoutTaxes + "$");
        System.out.println("Wage With Taxes= " + wageWithTaxes + "$");
    }
}