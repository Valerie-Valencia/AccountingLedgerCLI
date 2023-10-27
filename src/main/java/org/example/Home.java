package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Home {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        HomeScreen.showHomeScreen();
    }

    ;

    public static void homeChoice() {
        do {

            char homeChoice = scanner.next().toUpperCase().charAt(0);

            try {
                switch (homeChoice) {
                    case 'D' -> addDeposit();
                    case 'P' -> makePayment();
                    case 'L' -> LedgerScreen.showLedgerScreen();
                    case 'X' -> exitApp();
                    default -> System.out.println("Please enter valid choice: ");
                }
            } catch (Exception e) {
                System.out.println("There was an error");
                e.printStackTrace();
            }
        } while (true);
    }

    public static void addDeposit() {
        scanner.nextLine();
        System.out.println
                (
                        """
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                \t ;;   ENTER DEPOSIT DETAILS   ;;
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:
                                """
                );
        System.out.println("Enter Deposit Date (yyyy-MM-dd):");
        String depositDate = scanner.nextLine();
        System.out.println("Enter Deposit Time (HH:MM:SS): ");
        String depositTime = scanner.nextLine();
        System.out.println("Enter Deposit Description: ");
        String depositDescription = scanner.nextLine();
        System.out.println("Enter Deposit Vendor: ");
        String depositVendor = scanner.nextLine();
        System.out.println("Enter Deposit Amount: ");
        String depositAmount = scanner.nextLine();

        transactionLog(depositDate, depositTime, depositDescription, depositVendor, depositAmount);
        HomeScreen.showHomeScreen();
    }

    ;

    public static void makePayment() {
        scanner.nextLine();
        System.out.println
                (
                        """
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                \t ;;   ENTER PAYMENT DETAILS   ;;
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                """
                );
        System.out.println("Enter Payment Date (yyyy-MM-dd): ");
        String paymentDate = scanner.nextLine();
        System.out.println("\n Enter Payment Time (HH:MM:SS): ");
        String paymentTime = scanner.nextLine();
        System.out.println("\n Enter Payment Description: ");
        String paymentDescription = scanner.nextLine();
        System.out.println("\n Enter Payment Vendor: ");
        String paymentVendor = scanner.nextLine();
        System.out.println("\n Enter Payment Amount: ");
        String paymentAmount = scanner.nextLine();
        System.out.println("PAYMENT HAS BEEN MADE!");

        transactionLog(paymentDate, paymentTime, paymentDescription, paymentVendor, paymentAmount);
        HomeScreen.showHomeScreen();
    }

    ;

    public static void transactionLog(String d, String t, String de, String v, String a) {
        String delimiter = "|";
        try (FileWriter fileWriter = new FileWriter("transactions.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write
                    (
                            d + delimiter + t + delimiter +
                                    de + delimiter + v + delimiter + a
                    );
            bufferedWriter.append("\n");
            bufferedWriter.close();
            System.out.println("DEPOSIT HAS BEEN ADDED!");
            scanner.nextLine();
        } catch (IOException e) {
            System.out.println("There was an error.");
            e.printStackTrace();
        }
    }


    public static void exitApp() {
        System.out.println("NOW EXITING APPLICATION....");
        System.out.println(" ");
        System.exit(0);
    }


}