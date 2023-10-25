package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Home {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        showHomeScreen();
    };

    public static void showHomeScreen()
    {   System.out.println
        (
                "\t HOME" +
                "\n [D] Add Deposit" +
                "\n [P] Make Payment (Debit)" +
                "\n [L] Ledger" +
                "\n [X] Exit"
        );
        char homeChoice = scanner.next().toUpperCase().charAt(0);
        switch(homeChoice)
        {
            case 'D': addDeposit();
                break;
            case 'P': makePayment();
                break;
            case 'L': Ledger.showLedgerScreen();
                break;
            case 'X': exitApp();
                break;
            default: //add code
        }
    }

    public static void addDeposit()
    {
        String delimiter = "\\|";
        System.out.println
        (
                "\t Please Enter Deposit Details:" +
                "\n Enter Deposit Date (YYYY-MM-DD): "
        );
        String depositDate = scanner.nextLine();
        System.out.println("\n Enter Deposit Time (HH:MM:SS): ");
        String depositTime = scanner.nextLine();
        System.out.println("\n Enter Deposit Description: ");
        String depositDescription = scanner.nextLine();
        System.out.println("\n Enter Deposit Vendor: ");
        String depositVendor = scanner.nextLine();
        System.out.println("\n Enter Deposit Amount: ");
        String depositAmount = scanner.nextLine();

        try(FileWriter depositWriter = new FileWriter("transactions.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(depositWriter))
        {
            depositWriter.write
            (
                    depositDate + delimiter +
                        depositTime + delimiter +
                        depositDescription + delimiter +
                        depositVendor + delimiter +
                        depositAmount + delimiter
            );
            depositWriter.close();
        }
        catch(IOException e)
        {
            // add code
        }
    };
    public static void makePayment()
    {
        String delimiter = "\\|";
        System.out.println
        (
                "\t Please Enter Payment Details:" +
                "\n Enter Payment Date (YYYY-MM-DD): "
        );
        String paymentDate = scanner.nextLine();
        System.out.println("\n Enter Payment Time (HH:MM:SS): ");
        String paymentTime = scanner.nextLine();
        System.out.println("\n Enter Payment Description: ");
        String paymentDescription = scanner.nextLine();
        System.out.println("\n Enter Payment Vendor: ");
        String paymentVendor = scanner.nextLine();
        System.out.println("\n Enter Payment Amount: ");
        String paymentAmount = scanner.nextLine();

        try(FileWriter paymentWriter = new FileWriter("transactions.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(paymentWriter))
        {
            paymentWriter.write
            (
                    paymentDate + delimiter +
                        paymentTime + delimiter +
                        paymentDescription + delimiter +
                        paymentVendor + delimiter +
                        paymentAmount + delimiter
            );
            paymentWriter.close();
        }
        catch(IOException e)
        {
            // add code
        }
    };
    public static void exitApp(){};

}