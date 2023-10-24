package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;

public class HomeScreen implements ActionListener {

    // variables for deposit
    Date date;
    Time time;
    String productDescription;
    String vendorName;
    double amount;

    JFrame frame = new JFrame();
    JButton depositButton = new JButton("Add Deposit");
    JButton debitButton = new JButton("Make Payment (Debit)");
    JButton ledgerButton = new JButton("Ledger");
    JButton exitButton = new JButton("Exit");

    JLabel homeTitle = new JLabel("HOME SCREEN");
    JLabel appName = new JLabel("W O R K E R  B E E");
    JLabel appSubTitle = new JLabel("ACCOUNTING LEDGER");
    JLabel appImage = new JLabel(new ImageIcon("slowbee.gif"));

    //constructor

    HomeScreen() {

        homeTitle.setBounds(105,200,300,50);
        homeTitle.setFont(new Font(null,Font.BOLD,25));

        appSubTitle.setBounds(150,120,150,50);
        appSubTitle.setFont(new Font(null,Font.PLAIN,9));

        appName.setBounds(150,100,150,50);
        appName.setFont(new Font(null,Font.BOLD,12));

        appImage.setBounds(0,0,420,250);

        depositButton.setBounds(100, 300, 200, 40);
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);

        debitButton.setBounds(100, 350, 200, 40);
        debitButton.setFocusable(false);
        debitButton.addActionListener(this);

        ledgerButton.setBounds(100, 400, 200, 40);
        ledgerButton.setFocusable(false);
        ledgerButton.addActionListener(this);

        exitButton.setBounds(100, 450, 200, 40);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        frame.add(appSubTitle);
        frame.add(appName);
        frame.add(appImage);
        frame.add(homeTitle);
        frame.add(depositButton);
        frame.add(debitButton);
        frame.add(ledgerButton);
        frame.add(exitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,720);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        System.out.println("Hello world!");

        System.out.println("\n\t\t HOME SCREEN" +
                "\n" +
                "\n\t [D] Add Deposit" +
                "\n\t [P] Make Payment (Debit)" +
                "\n\t [L] Ledger" +
                "\n\t [X] Exit");

        /*
        Switch(homeScreenChoice){
        case 'D': addDeposit();
        break;
        case 'P': makePayment();
        break;
        case 'L': LedgerScreen.main();
        break;
        case 'X': exit();
        break;
        }
         */

    }
    // add deposit method
    // public addDeposit();
    // make payment method
    // public makePayment();
    // call ledger class main method
    // exit application method
    // public exit();

    public String toString(){
        return date + "|" + time + "|" + productDescription + "|" + vendorName + "|" + amount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}