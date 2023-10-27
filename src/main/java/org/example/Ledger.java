package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Ledger {

    public static ArrayList<Transaction> transactionList;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LedgerScreen.showLedgerScreen();
    }

    ;

    public static void ledgerChoice() {
        do {
            char ledgerChoice = scanner.next().toUpperCase().charAt(0);
            boolean validInput = true;

            try {
                switch (ledgerChoice) {
                    case 'A' -> displayAll();
                    case 'D' -> displayDeposits();
                    case 'P' -> displayPayments();
                    case 'R' -> ReportScreen.showReportScreen();
                    case 'H' -> HomeScreen.showHomeScreen();
                    default -> System.out.println("Please enter valid choice: ");

                }
            } catch (Exception e) {
                System.out.println("There was an error");
                e.printStackTrace();
            }
        }
        while (true);

    }

    public static void displayAll() {
        System.out.println
                (
                        """
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                \t ;;  DISPLAYING ALL ENTRIES   ;;
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                """
                );
        for (Transaction transaction : transactionList) {
            System.out.println(
                    transaction.getTransactionDate() + " " +
                            transaction.getTransactionTime() + " " +
                            transaction.getTransactionDesc() + " " +
                            transaction.getTransactionVendor() + " " +
                            transaction.getTransactionAmount() + " "
            );
        }
    }

    ;

    public static void displayDeposits() {
        System.out.println
                (
                        """
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                \t ;;  DISPLAYING ALL DEPOSITS  ;;
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                """
                );
        for (Transaction transaction : transactionList) {
            String string = String.valueOf(transaction.getTransactionAmount());
            if (!string.contains("-")) {
                System.out.println(
                        transaction.getTransactionDate() + " " +
                                transaction.getTransactionTime() + " " +
                                transaction.getTransactionDesc() + " " +
                                transaction.getTransactionVendor() + " " +
                                transaction.getTransactionAmount()
                );
            }
        }

    }

    ;

    public static void displayPayments() {
        System.out.println
                (
                        """
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                \t ;;  DISPLAYING ALL PAYMENTS  ;;
                                \t ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                """
                );
        for (Transaction transaction : transactionList) {
            String string = String.valueOf(transaction.getTransactionAmount());
            if (string.contains("-")) {
                System.out.println(
                        transaction.getTransactionDate() + " " +
                                transaction.getTransactionTime() + " " +
                                transaction.getTransactionDesc() + " " +
                                transaction.getTransactionVendor() + " " +
                                transaction.getTransactionAmount()
                );
            }
        }
    }

    ;

    public static ArrayList<Transaction> readTransactions() {
        ArrayList<Transaction> transactionList = new ArrayList<>();
        try {
            FileReader filereader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] fields = input.split("\\|");

                Transaction transaction = new Transaction(LocalDate.parse(fields[0]),
                        LocalTime.parse(fields[1]), fields[2], fields[3], Double.parseDouble(fields[4]));
                transactionList.add(transaction);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Comparator<Transaction> dateCompare = Comparator.comparing(Transaction::getTransactionDate).reversed();
        Comparator<Transaction> timeCompare = Comparator.comparing(Transaction::getTransactionTime).reversed();
        Comparator<Transaction> descriptionCompare = Comparator.comparing(Transaction::getTransactionDesc).reversed();
        transactionList.sort(dateCompare.thenComparing(timeCompare));
        transactionList.sort(descriptionCompare);

        return transactionList;
    }
}
