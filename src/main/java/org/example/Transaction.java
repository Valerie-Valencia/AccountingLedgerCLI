package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

    // VARIABLES
    LocalDate transactionDate;
    LocalTime transactionTime;
    String transactionDesc;
    String transactionVendor;
    double transactionAmount;

    // CONSTRUCTOR
    Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount){
        this.transactionDate = date;
        this.transactionTime = time;
        this.transactionDesc = description;
        this.transactionVendor = vendor;
        this.transactionAmount = amount;
    }
    // SETTERS
    public void setTransactionDate(LocalDate setDate){
        this.transactionDate = setDate;
    }
    public void setTransactionTime(LocalTime setTime){
        this.transactionTime = setTime;
    }
    public void setTransactionDesc(String setDescription){
        this.transactionDesc = setDescription;
    }
    public void setTransactionVendor(String setVendor){
        this.transactionVendor = setVendor;
    }
    public void setTransactionAmount(double setAmount){
        this.transactionAmount = setAmount;
    };

    // GETTERS
    public LocalDate getTransactionDate(){
        return transactionDate;
    }
    public LocalTime getTransactionTime(){
        return transactionTime;
    }
    public String getTransactionDesc(){
        return transactionDesc;
    }
    public String getTransactionVendor(){
        return transactionVendor;
    }
    public double getTransactionAmount(){
        return transactionAmount;
    };

    // TO STRING
    @Override
    public String toString(){
        return "\n" + getTransactionDate() +
                "\n" + getTransactionTime() +
                "\n" + getTransactionDesc() +
                "\n" + getTransactionVendor() +
                "\n" + getTransactionAmount();
    }
}
