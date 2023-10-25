package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {

    static ArrayList<Transaction> transactionList = new ArrayList<>();

    public static void main(String[] args)
    {
       showLedgerScreen();
    };

    public static void showLedgerScreen()
    {
        System.out.println
        (
                "\t LEDGER" +
                "\n [A] ALL (display all entries)" +
                "\n [D] Deposits" +
                "\n [P] Payments" +
                "\n [R] Reports" +
                "\n [H] Home"
        );

        Scanner scanner = new Scanner(System.in);
        char ledgerChoice = scanner.next().toUpperCase().charAt(0);

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
            default: // prompt menu again

        }
    }

    public static void displayAll(){
        System.out.println("Displaying All Entries:");
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
        System.out.println("Displaying all Deposits:");
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
        System.out.println("Displaying all Payments");
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
