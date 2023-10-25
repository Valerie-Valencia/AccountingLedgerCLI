package org.example;

import java.util.Scanner;

public class Report{

    public static void main(String[] args){
        System.out.println("\t REPORT" +
                "\n [1] Month to Date" +
                "\n [2] Previous Month" +
                "\n [3] Year to Date" +
                "\n [4] Previous Year" +
                "\n [5] Search by Vendor" +
                "\n [0] Back");

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
            case 0: return;
            default: //prompt menu again
        }
    }
    public static void monthToDate(){};
    public static void previousMonth(){};
    public static void yearToDate(){};
    public static void previousYear(){};
    public static void searchByVendor(){};

}
