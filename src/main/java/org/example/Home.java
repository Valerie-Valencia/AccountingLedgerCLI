package org.example;

import java.util.Scanner;

public class Home {
    public static void main(String[] args)
    {
        System.out.println("\tHOME" +
                "\n [D] Add Deposit" +
                "\n [P] Make Payment (Debit)" +
                "\n [L] Ledger" +
                "\n [X] Exit");

        Scanner scanner = new Scanner(System.in);
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
    public static void addDeposit(){};
    public static void makePayment(){};
    public static void exitApp(){};

}