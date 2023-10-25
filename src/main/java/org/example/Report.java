package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

import static org.example.Ledger.transactionList;

public class Report implements Comparable<Transaction>{

    public static void main(String[] args)
    {
        showReportScreen();
    }

    public static void showReportScreen()
    {
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

        Scanner scanner = new Scanner(System.in);
        int reportChoice = scanner.nextInt();

        switch(reportChoice){
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
            case 0: Home.showHomeScreen();
            default: //prompt menu again
        }
    }
    public static void monthToDate()
    {
        //return transactionList.sort();
        // Collection.sort(transactionList);
    };
    public static void previousMonth(){};
    public static void yearToDate(){};
    public static void previousYear(){};
    public static void searchByVendor(){};
    @Override
    public int compareTo(Transaction o) {
        return o.getTransactionDate().compareTo(o.getTransactionDate());
    }
}
