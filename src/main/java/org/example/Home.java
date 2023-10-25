package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Home {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println
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
            case 'L': //go to ledger
            break;
            case 'X': exitApp();
            break;
            default: //add code
        }
    };
    public static void addDeposit()
    {
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
    };
    public static void makePayment()
    {
        System.out.println
        (
                "\t Please Enter Payment Details: ");
    };
    public static void exitApp(){};

}