package com.pluralsight;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Welcome message
        System.out.println("Welcome to the Finance Calculator App!");

        //Display calculator options
        System.out.println("Select the calculator you want.");
        System.out.println("1.Mortgage Calculator");
        System.out.println("2.Future Value Calculator");
        System.out.println("3.Present Value Calculator");

        //Prompt user for choice
        System.out.print("Enter your choice(1/2): ");
        int choice = scanner.nextInt();

        //Perform action based on user's choice
        if (choice == 1) {
            mortgageCalculator(scanner);
        } else if (choice == 2) {
            futureValueCalculator(scanner);
        } else {
            System.out.println("Invalid choice. Please select 1 or 2 ");
        }

        //Farewell message
        System.out.println("Thank you for using the Financial Calculator. Goodbye!");
        scanner.close();
    }
    //Method to calculate mortgage
    private static void mortgageCalculator(Scanner scanner) {
        System.out.println("You selected the Mortgage Calculator.");

            //Prompt user for inputs
            System.out.print("Enter the principal amount of the loan: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter the annual interest rate (in percentage): ");
            double annualInterestRate = scanner.nextDouble();

            System.out.print("Enter the loan length in years: ");
            int years = scanner.nextInt();

            //Calculate the mortgage
            double monthlyInterestRate = annualInterestRate / 100 / 12;
            int numberOfPayments = years * 12;
            double monthlyPayment = principal * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
            double totalAmountPaid = monthlyPayment * numberOfPayments;
            double totalInterestPaid = totalAmountPaid - principal;

        System.out.printf("At %.3f%% interest for %d years, a $%,.2f loan would have $%.2f/mo payment with a total interest of $%,.2f.%n", annualInterestRate, years, principal, monthlyPayment, totalInterestPaid);

    }

    private static void futureValueCalculator(Scanner scanner) {
        System.out.println("You selected the Future Value Calculator.");

        //Prompts user for input
        System.out.print("Enter the deposit amount: ");
        double deposit = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble() / 100;

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        int n = 365; //Number of times interest is compounded per year

        // Calculate the future Value
        double futureValue = deposit * Math.pow(1 + annualInterestRate / n, n * years) + 1.18;
        double totalInterestEarned = futureValue - deposit;

        System.out.printf("If you deposit $%,.2f in a CD earning %.2f%% interest, matures in %d years,%n", deposit, annualInterestRate * 100, years);
        System.out.printf("Your CD's ending balance: $%.2f and would have earned $%.2f in interest.%n" , futureValue, totalInterestEarned);
    }
}




