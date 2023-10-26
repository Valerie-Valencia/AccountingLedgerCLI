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
    {
        try
        {
            System.out.println
            (
                   """
                   \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                   \t ;;                                                                                ;;
                   \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                   \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                   \t ;;       ;;;;;                                                          ;;;;;     ;;
                   \t ;;       ;;;;;                      /////////////////|                  ;;;;;     ;;
                   \t ;;       ;;;;;                     ///////////////// |                  ;;;;;     ;;
                   \t ;;       ;;;;;                     ::::::::::::::::: |                  ;;;;;     ;;
                   \t ;;       ;;:::                     ::::::::::::::::: |                  ;;;;;     ;;
                   \t ;;       ;;;;;                     :::::::::::::::::/                   ;;;;;     ;;
                   \t ;;       ;;;;;                                                          ;;;;;     ;;
                   \t ;;       ;;;;;                      H O M E  M E N U                    ;;;;;     ;;
                   \t ;;       ;;;;;                                                          ;;;;;     ;;
                   \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                   \t ;;       ;;;;;      [D]  ;;            ADD DEPOSIT           ;;         ;;;;;     ;;
                   \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                   \t ;;       ;;;;;                                                          ;;;;;     ;;
                   \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                   \t ;;       ;;;;;      [P]  ;;           MAKE PAYMENT           ;;         ;;;;;     ;;
                   \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                   \t ;;       ;;;;;                                                          ;;;;;     ;;
                   \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                   \t ;;       ;;;;;      [L]  ;;              LEDGER              ;;         ;;;;;     ;;
                   \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                   \t ;;       ;;;;;                                                          ;;;;;     ;;
                   \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                   \t ;;       ;;;;;      [X]  ;;               EXIT               ;;         ;;;;;     ;;
                   \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                   \t ;;       ;;;;;                                                          ;;;;;     ;;
                   \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                   \t ;;       ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;     ;;
                    \t ;;                                                                                ;;
                    \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                      """
            );
            /*
            System.out.println
            (
                    "\t HOME" +
                    "\n [D] Add Deposit" +
                    "\n [P] Make Payment (Debit)" +
                    "\n [L] Ledger" +
                    "\n [X] Exit"
            );*/

            char homeChoice = scanner.next().toUpperCase().charAt(0);
            boolean validInput = true;

            while(true)
            {
                switch(homeChoice)
                {
                    case 'D': addDeposit();
                    break;
                    case 'P': makePayment();
                    break;
                    case 'L': Ledger.showLedgerScreen();
                    break;
                    case 'X': System.exit(0);
                    break;
                    default: validInput = false;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(" ");
        }
    }

    public static void addDeposit()
    {
        String delimiter = "\\|";
        String depositDate = scanner.nextLine();
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;;   ENTER DEPOSIT DETAILS   ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:
                
                Enter Deposit Date (YYYY-MM-DD):
                """
        );
        String depositTime = scanner.nextLine();
        System.out.println("Enter Deposit Time (HH:MM:SS): ");
        String depositDescription = scanner.nextLine();
        System.out.println("Enter Deposit Description: ");
        String depositVendor = scanner.nextLine();
        System.out.println("Enter Deposit Vendor: ");
        String depositAmount = scanner.nextLine();
        System.out.println("Enter Deposit Amount: ");

        System.out.println("DEPOSIT HAS BEEN ADDED!");

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
        String paymentDate = scanner.nextLine();
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;;   ENTER PAYMENT DETAILS   ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                
                Enter Payment Date (YYYY-MM-DD):
                """
        );
        String paymentTime = scanner.nextLine();
        System.out.println("\n Enter Payment Time (HH:MM:SS): ");
        String paymentDescription = scanner.nextLine();
        System.out.println("\n Enter Payment Description: ");
        String paymentVendor = scanner.nextLine();
        System.out.println("\n Enter Payment Vendor: ");
        String paymentAmount = scanner.nextLine();
        System.out.println("\n Enter Payment Amount: ");

        System.out.println("PAYMENT HAS BEEN MADE!");

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
}