package org.example;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.Ledger.transactionList;

public class Report {

    static Scanner scanner = new Scanner(System.in);
    static String delimiter = "|";
    static LocalDate todayDate = LocalDate.now();

    public static void main(String[] args) {
        ReportScreen.showReportScreen();
    }

    public static void reportChoice() {
        do {
            int reportChoice = scanner.nextInt();
            boolean validInput = true;

            try {
                switch (reportChoice) {
                    case 1 -> monthToDate();
                    case 2 -> previousMonth();
                    case 3 -> yearToDate();
                    case 4 -> previousYear();
                    case 5 -> searchByVendor();
                    case 0 -> LedgerScreen.showLedgerScreen();
                    default -> System.out.println("Please enter valid choice: ");

                }
            } catch (Exception e) {
                System.out.println("There was an error");
                e.printStackTrace();
            }
        }
        while (true);
    }

    public static void monthToDate() {
        LocalDate beginningOfMonth = todayDate.withDayOfMonth(1);
        System.out.println
                (
                        """
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                \t ;; MONTH TO DATE REPORT ENTRIES ;;
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                """
                );

        for (Transaction t : transactionList) {
            if (t.getTransactionDate().isAfter(beginningOfMonth.minusDays(1)) ||
                    t.getTransactionDate().isEqual(todayDate)) {
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
    }

    ;

    public static void previousMonth() {
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

        for (Transaction t : transactionList) {
            if (t.getTransactionDate().isEqual(previousMonth)) {
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
    }

    ;

    public static void yearToDate() {
        LocalDate beginningOfYear = todayDate.withDayOfYear(1);
        System.out.println
                (
                        """
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                \t ;; YEAR TO DATE REPORT ENTRIES ;;
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                """
                );

        for (Transaction t : transactionList) {
            if (t.getTransactionDate().isAfter(beginningOfYear.minusDays(1)) ||
                    t.getTransactionDate().isEqual(todayDate)) {
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
    }

    ;

    public static void previousYear() {
        int previousYear = todayDate.minusYears(1).getYear();
        System.out.println
                (
                        """
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                \t ;; PREVIOUS YEAR REPORT ENTRIES ;;
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                """
                );

        for (Transaction t : transactionList) {
            if (t.getTransactionDate().getYear() == previousYear &&
                    t.getTransactionDate().getYear() != todayDate.getYear()) {
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
    }

    ;

    public static void searchByVendor() {
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
        for (Transaction t : transactionList) {
            if (vendorChoice.equals(t.getTransactionVendor())) {
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
    }

    ;

    public static void returnLedger() {
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
        try {
            do {
                switch (userChoice) {
                    case 0:
                        LedgerScreen.showLedgerScreen();
                        break;
                    default:
                        validInput = false;
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(" ");
        }
    }

}
