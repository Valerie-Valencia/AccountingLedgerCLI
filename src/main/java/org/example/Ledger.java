package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {

    static ArrayList<Transaction> transactionList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
       showLedgerScreen();
    };

    public static void showLedgerScreen()
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
                    \t ;;       ;;;;;                    L E D G E R  M E N U                  ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [A]  ;;                ALL               ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [D]  ;;             DEPOSITS             ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [P]  ;;             PAYMENTS             ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [R]  ;;             REPORTS              ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;; 
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [H]  ;;               HOME               ;;         ;;;;;     ;;
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
                    "\t LEDGER" +
                    "\n [A] ALL (display all entries)" +
                    "\n [D] Deposits" +
                    "\n [P] Payments" +
                    "\n [R] Reports" +
                    "\n [H] Home"
            );

             */

            char ledgerChoice = scanner.next().toUpperCase().charAt(0);
            boolean validInput = true;

            while(true)
            {
                switch(ledgerChoice)
                {
                    case 'A': displayAll();
                    break;
                    case 'D': displayDeposits();
                    break;
                    case 'P': displayPayments();
                    break;
                    case 'R': Report.showReportScreen();
                    break;
                    case 'H': Home.showHomeScreen();
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

    public static void displayAll(){
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;;  DISPLAYING ALL ENTRIES   ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );
        for (Transaction transaction : transactionList)
        {
            System.out.println(
                    transaction.getTransactionDate() + " " +
                    transaction.getTransactionTime() + " " +
                    transaction.getTransactionDesc() + " " +
                    transaction.getTransactionVendor() + " " +
                    transaction.getTransactionAmount() + " "
            );
        }
    };
    public static void displayDeposits(){
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;;  DISPLAYING ALL DEPOSITS  ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );
        for (Transaction transaction : transactionList)
        {
            if(transaction.getTransactionAmount() > 0)
            {
                System.out.println(
                        transaction.getTransactionDate() + " " +
                        transaction.getTransactionTime() + " " +
                        transaction.getTransactionDesc() + " " +
                        transaction.getTransactionVendor() + " " +
                        transaction.getTransactionAmount()
                );
            }
        }

    };
    public static void displayPayments(){
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;;  DISPLAYING ALL PAYMENTS  ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );
        for (Transaction transaction : transactionList)
        {
            if(transaction.getTransactionAmount() < 0)
            {
                System.out.println(
                        transaction.getTransactionDate() + " " +
                        transaction.getTransactionTime() + " " +
                        transaction.getTransactionDesc() + " " +
                        transaction.getTransactionVendor() + " " +
                        transaction.getTransactionAmount()
                );
            }
        }
    };

    public static ArrayList<Transaction> transactionParse(){
        String delimiter = "\\|";
        Scanner scanner = new Scanner(System.in);

        try(FileReader filereader = new FileReader("transactions.csv");
            BufferedReader bufferedreader = new BufferedReader(filereader))
        {
            String input = null;

            while((input = bufferedreader.readLine()) != null)
            {
                String[] recordDetails = input.split(delimiter);

                LocalDate date = LocalDate.parse(recordDetails[0]);
                LocalTime time = LocalTime.parse(recordDetails[1]);
                String description = recordDetails[2];
                String vendor = recordDetails[3];
                double amount = Double.parseDouble(recordDetails[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactionList.add(transaction);

            }
            bufferedreader.close();
        }
        catch(Exception e){
            System.out.println(" ");
        }

        return transactionList;
    }

}
