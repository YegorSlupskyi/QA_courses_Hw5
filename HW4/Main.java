package HW4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println("____________________________");
        task2();
        System.out.println("____________________________");
        task3();
        System.out.println("____________________________");
        task4();
        System.out.println("____________________________");


    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);

        boolean doWeContinue = true;
        do {
            System.out.println("Select the shape (1-4)");
            System.out.println("1 - rectangle");
            System.out.println("2 - rectangular triangle");
            System.out.println("3 - isosceles right triangle");
            System.out.println("4 - triangle");

            int shape = scanner.nextInt();

            if (shape <= 0 || shape > 4) {
                System.out.println("ERROR: THERE IS NO SUCH SHAPE!");
                continue;
            }

            System.out.println("Enter the height");
            int height = scanner.nextInt();
            if (height <= 0) {
                System.out.println("The height must be positive");
                continue;
            }

            switch (shape) {
                case 1 -> {
                    System.out.println("Enter the width");
                    int width = scanner.nextInt();
                    if (width <= 0) {
                        System.out.println("The width must be positive");
                        continue;
                    }

                    for (int counterHeight = 0; counterHeight < height; counterHeight++) {
                        for (int counterWidth = 0; counterWidth < width; counterWidth++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }
                case 2 -> {
                    for (int counterHeight = 0; counterHeight < height; counterHeight++) {
                        for (int counterWidth = 0; counterWidth < (counterHeight + 1); counterWidth++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }

                case 3 -> {
                    for (int counterHeight = 1; counterHeight <= height; counterHeight++) {
                        for (int counterWidth = 1; counterWidth <= height; counterWidth++) {
                            if (counterHeight + counterWidth <= height) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }

                }

                case 4 -> {
                    for (int counterHeight = 1; counterHeight <= height; counterHeight++) {
                        for (int counterWidth = 1; counterWidth <= (height * 2) - 1; counterWidth++) {
                            if (counterWidth <= ((height * 2) - 1) / 2) {
                                //we are on the left side of the triangle
                                if (counterWidth + counterHeight > height) {
                                    System.out.print("*");
                                } else {
                                    System.out.print(" ");
                                }
                            } else {
                                //we are on the right side of the triangle
                                if (counterWidth - counterHeight <= height - 1) {
                                    System.out.print("*");
                                } else {
                                    System.out.print(" ");
                                }
                            }
                        }
                        System.out.println();
                    }
                }
            }
            System.out.println("Do you wanna draw one more shape? ");
            String answer = scanner.next();
            if ("no".equalsIgnoreCase(answer)) {
                doWeContinue = false;
            }
            System.out.println(answer);
        } while (doWeContinue);
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a series of numbers separated by space");
        String lineOfNumbers = scanner.nextLine();
        System.out.println(lineOfNumbers);

        String splittedLine[] = lineOfNumbers.split(" ");
        int numbers[] = new int[splittedLine.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(splittedLine[i]);
        }

        printArray(numbers, "base", ", ");

        bubbleSortAscending(numbers);
        printArray(numbers, "asc", ", ");

        bubbleSortDescending(numbers);
        printArray(numbers, "desc", ", ");

        innerSort(numbers);
        printArray(numbers, "inner", ", ");

    }

    public static void task3() {

        System.out.println("Enter the loan amount");
        Scanner scanner = new Scanner(System.in);
        double loanAmount = scanner.nextDouble();

        System.out.println("Enter the loan rate");
        double loanRate = scanner.nextDouble();

        System.out.println("What would you like to count? (1-2)");
        System.out.println("1 - Monthly installments Amount");
        System.out.println("2 - Monthly installments Sum");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Enter installment");
                double installment = scanner.nextDouble();
                int amountOfInstallments = 0;
                while (loanAmount > 0) {
                    double initialLoanAmount = loanAmount;
                    loanAmount *= (1 + loanRate / 100);
                    loanAmount -= installment;

                    if (loanAmount >= initialLoanAmount) {
                        System.out.println("You are in a debt hole \uD83D\uDE25");
                        return;
                    }
                    amountOfInstallments++;
                }
                System.out.println("Your installment amount for this loan = " + amountOfInstallments);
            }
            case 2 -> {
                System.out.println("Enter amount of installments ");
                int amountOfInstallments = scanner.nextInt();
                double totalLoanForThePeriod = loanAmount * Math.pow(1 + loanRate / 100, amountOfInstallments);
                double installment = totalLoanForThePeriod / amountOfInstallments;
                System.out.println("Your should pay " + installment + " per month to pay this loan in " + amountOfInstallments + " months");
            }
        }

    }

    static int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String months[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "NOV", "DEC"};

    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        double rate = scanner.nextDouble();
        double taxPercentage = scanner.nextDouble();
        double workHoursPerDay = 8.0;

        double totalSalaryWithoutTaxes = 0;
        double totalSalaryWithTaxes = 0;
        for (int monthNumber = 0; monthNumber < months.length; monthNumber++) {
            double salaryForMonthWithoutTaxes = 0;
            double salaryForMonthWithTaxes = 0;
            for (int dayOfMonthNumber = 0; dayOfMonthNumber < daysInMonth[monthNumber]; dayOfMonthNumber++) {
                int dayOfTheYearNumber = sumOfDaysThatPassedBeforeTheMonth(monthNumber) + dayOfMonthNumber;
                if (dayOfTheYearNumber % 7 < 5) {
                    salaryForMonthWithoutTaxes += rate * workHoursPerDay;
                    salaryForMonthWithTaxes += salaryForMonthWithoutTaxes * (1 - taxPercentage / 100);
                }
            }
            System.out.println(months[monthNumber] + " " + salaryForMonthWithoutTaxes + " " + salaryForMonthWithTaxes);
            totalSalaryWithoutTaxes += salaryForMonthWithoutTaxes;
            totalSalaryWithTaxes += salaryForMonthWithTaxes;
        }
        System.out.println("TOTAL: " + totalSalaryWithoutTaxes + " " + totalSalaryWithTaxes);
    }

    public static int sumOfDaysThatPassedBeforeTheMonth(int monthNumber) {
        int sum = 0;
        for (int i = 0; i < monthNumber; i++) {
            sum += daysInMonth[i];
        }
        return sum;
    }


    public static void swapElementsOfArray(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int array[], String arrayTitle, String divisor) {
        System.out.print(arrayTitle + ": ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ((i == array.length - 1) ? "" : divisor));
        }

        System.out.println();
        System.out.println("____________________________");
    }

    public static void bubbleSortAscending(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swapElementsOfArray(array, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortDescending(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    swapElementsOfArray(array, j, j + 1);
                }
            }
        }
    }

    public static void innerSort(int array[]) {
        bubbleSortDescending(array);

        int doppelganger[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            doppelganger[i] = array[i];
        }
        int n = array.length;
        int j = 1;
        for (int i = 1; i < array.length; i++) {
            if (i % 2 == 1) {
                array[n - j] = doppelganger[i];
            } else {
                array[j] = doppelganger[i];
                j++;
            }
        }
    }


}