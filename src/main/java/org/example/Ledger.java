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

        LedgerScreen.showLedgerScreen();
    };

    public static void ledgerChoice()
    {
        do
        {
            char ledgerChoice = scanner.next().toUpperCase().charAt(0);
            boolean validInput = true;

            try
            {
                switch(ledgerChoice)
                {
                    case 'A' -> displayAll();
                    case 'D' -> displayDeposits();
                    case 'P' -> displayPayments();
                    case 'R' -> ReportScreen.showReportScreen();
                    case 'H'-> HomeScreen.showHomeScreen();
                    default -> System.out.println("Please enter valid choice: ");

                }
            }
            catch(Exception e)
            {
                System.out.println("There was an error");
                e.printStackTrace();
            }
        }
        while(true);

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
        String delimiter = "|";
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
