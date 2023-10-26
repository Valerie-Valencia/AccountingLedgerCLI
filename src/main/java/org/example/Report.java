package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static org.example.Ledger.transactionList;

public class Report{

    static Scanner scanner = new Scanner(System.in);
    static String delimiter = "|";
    static LocalDate todayDate = LocalDate.now();
    public static void main(String[] args)
    {
        showReportScreen();
    }

    public static void showReportScreen()
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
                    \t ;;       ;;;;;                    R E P O R T  M E N U                  ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [1]  ;;          MONTH TO DATE           ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [2]  ;;          PREVIOUS MONTH          ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [3]  ;;           YEAR TO DATE           ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [4]  ;;           PREVIOUS YEAR          ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [5]  ;;         SEARCH BY VENDOR         ;;         ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;                                                          ;;;;;     ;;
                    \t ;;       ;;;;;           ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;         ;;;;;     ;;
                    \t ;;       ;;;;;      [0]  ;;               BACK               ;;         ;;;;;     ;;
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
                    "\t REPORT" +
                    "\n [1] Month to Date" +
                    "\n [2] Previous Month" +
                    "\n [3] Year to Date" +
                    "\n [4] Previous Year" +
                    "\n [5] Search by Vendor" +
                    "\n [0] Back"
            );

             */

            int reportChoice = scanner.nextInt();
            boolean validInput = true;

            do {
                switch (reportChoice) {
                    case 1: monthToDate();
                    break;
                    case 2: previousMonth();
                    break;
                    case 3: yearToDate();
                    break;
                    case 4: previousYear();
                    break;
                    case 5: searchByVendor();
                    break;
                    case 0: Ledger.showLedgerScreen();
                    break;
                    default: validInput = false;
                    break;
                }
            } while (true);
        }
        catch(Exception e)
        {
            System.out.println(" ");
        }
    }
    public static void monthToDate()
    {
        LocalDate beginningOfMonth = todayDate.withDayOfMonth(1);
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;; MONTH TO DATE REPORT ENTRIES ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );

        for(Transaction t : transactionList)
        {
            if(t.getTransactionDate().isAfter(beginningOfMonth.minusDays(1)) ||
                  t.getTransactionDate().isEqual(todayDate))
            {
                System.out.println
                (
                        t.getTransactionDate() + delimiter +
                        t.getTransactionTime() + delimiter +
                        t.getTransactionDesc() + delimiter +
                        t.getTransactionVendor() + delimiter +
                        t.getTransactionAmount()
                );
            }
        }
        returnLedger();
    };
    public static void previousMonth()
    {
        LocalDate todayDate = LocalDate.now();
        LocalDate previousMonth = LocalDate.from(todayDate.minusMonths(1).getMonth());
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;; PREVIOUS MONTH REPORT ENTRIES ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );

        for(Transaction t : transactionList)
        {
            if(t.getTransactionDate().isEqual(previousMonth))
            {
                System.out.println
                (
                        t.getTransactionDate() + delimiter +
                        t.getTransactionTime() + delimiter +
                        t.getTransactionDesc() + delimiter +
                        t.getTransactionVendor() + delimiter +
                        t.getTransactionAmount() + delimiter
                );
            }
        }
        returnLedger();
    };
    public static void yearToDate()
    {
        LocalDate beginningOfYear = todayDate.withDayOfYear(1);
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;; YEAR TO DATE REPORT ENTRIES ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );

        for(Transaction t : transactionList)
        {
            if(t.getTransactionDate().isAfter(beginningOfYear.minusDays(1)) ||
               t.getTransactionDate().isEqual(todayDate))
            {
                System.out.println
                (
                        t.getTransactionDate() + delimiter +
                        t.getTransactionTime() + delimiter +
                        t.getTransactionDesc() + delimiter +
                        t.getTransactionVendor() + delimiter +
                        t.getTransactionAmount() + delimiter
                );
            }
        }
        returnLedger();
    };
    public static void previousYear()
    {
        int previousYear = todayDate.minusYears(1).getYear();
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;; PREVIOUS YEAR REPORT ENTRIES ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );

        for(Transaction t : transactionList)
        {
            if(t.getTransactionDate().getYear() == previousYear &&
               t.getTransactionDate().getYear() != todayDate.getYear())
            {
                System.out.println
                (
                        t.getTransactionDate() + delimiter +
                        t.getTransactionTime() + delimiter +
                        t.getTransactionDesc() + delimiter +
                        t.getTransactionVendor() + delimiter +
                        t.getTransactionAmount() + delimiter
                );
            }
        }
        returnLedger();
    };
    public static void searchByVendor()
    {
        String vendorChoice = scanner.nextLine();
        System.out.println
        (
                """
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t ;;    ENTER VENDOR DETAILS   ;;
                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                """
        );
        System.out.println("Enter Vendor Name: ");
        for(Transaction t : transactionList)
        {
            if(vendorChoice.equals(t.getTransactionVendor()))
            {
                System.out.println
                (
                        t.getTransactionDate() + delimiter +
                        t.getTransactionTime() + delimiter +
                        t.getTransactionDesc() + delimiter +
                        t.getTransactionVendor() + delimiter +
                        t.getTransactionAmount() + delimiter

                );
            }
        }
        returnLedger();
    };

    public static void returnLedger()
    {
        int userChoice = scanner.nextInt();
        System.out.println
        (
                """
                \t      ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                \t [0]  ;;       BACK  (LEDGER MENU)        ;;        
                \t      ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;    
                """
        );
        boolean validInput = true;
        try
        {
            do {
                switch (userChoice) {
                    case 0: Ledger.showLedgerScreen();
                    break;
                    default: validInput = false;
                    break;
                }
            } while (true);
        }
        catch(Exception e)
        {
            System.out.println(" ");
        }
    }

}
