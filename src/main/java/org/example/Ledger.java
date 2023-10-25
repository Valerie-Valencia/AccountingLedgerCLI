package org.example;

import java.util.Scanner;

public class Ledger {

    public static void main(String[] args){
        System.out.println("\tLEDGER" +
                "\n [A] ALL (display all entries)" +
                "\n [D] Deposits" +
                "\n [P] Payments" +
                "\n [R] Reports" +
                "\n [H] Home");

        Scanner scanner = new Scanner(System.in);
        char ledgerChoice = scanner.next().toUpperCase().charAt(0);

        switch(ledgerChoice) {
            case 'A': displayAll();
                break;
            case 'D': displayDeposits();
                break;
            case 'P': displayPayments();
                break;
            case 'R': displayReports();
                break;
            case 'H': return;
            default: // prompt menu again

        }
    };

    public static void displayAll(){
        //use an array list sort;
    };
    public static void displayDeposits(){
        // use an array list sort:
        //transactionList().stream().filter();
    };
    public static void displayPayments(){
        // use an array list sort:

    };
    public static void displayReports(){
        //Report.main(new String[]{});
    };
    /*
        public static void returnHome(){
            Home.main(new String[]{});
        };

     */
    public static ArrayList<Transaction> transactionList(){
        ArrayList<Transaction> transactionList = new ArrayList<>();
        String delimiter = "\\|";
        Scanner scanner = new Scanner(System.in);

        try( FileReader filereader = new FileReader("transactions.csv");
             BufferedReader bufferedreader = new BufferedReader(filereader)){
            String input = null;

            while((input = bufferedreader.readLine()) != null){
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
            System.out.println("Sorry, file could not be found");
        }

        return transactionList;
    }

}