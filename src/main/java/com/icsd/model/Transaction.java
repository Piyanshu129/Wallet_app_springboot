package com.icsd.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@SequenceGenerator(initialValue = 1001, name = "tran", sequenceName = "tran")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran")
    private int transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private LocalDate transactionDate;

    private double amount;

    private String description;

    private int fromAccount;

    private int toAccount;
}


//@Entity
//@SequenceGenerator(initialValue = 1001, name = "tran", sequenceName = "tran")
//public class Transaction {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran")
//    private int transactionId;
//
//    
//    @Enumerated(EnumType.STRING)
//    private TransactionType transactionType;
//
//    private LocalDate transactionDate;
//
//    private double amount;
//
//    private String description;
//
//    private int fromAccount;
//
//    private int toAccount;
//
//    // Constructors
//    public Transaction() {
//    }
//
//    public Transaction(TransactionType transactionType, LocalDate transactionDate, double amount, String description,
//            int fromAccount, int toAccount) {
//        this.transactionType = transactionType;
//        this.transactionDate = transactionDate;
//        this.amount = amount;
//        this.description = description;
//        this.fromAccount = fromAccount;
//        this.toAccount = toAccount;
//    }
//
//    // Getters and Setters
//    public int getTransactionId() {
//        return transactionId;
//    }
//
//    public void setTransactionId(int transactionId) {
//        this.transactionId = transactionId;
//    }
//
//    public TransactionType getTransactionType() {
//        return transactionType;
//    }
//
//    public void setTransactionType(TransactionType transactionType) {
//        this.transactionType = transactionType;
//    }
//
//    public LocalDate getTransactionDate() {
//        return transactionDate;
//    }
//
//    public void setTransactionDate(LocalDate transactionDate) {
//        this.transactionDate = transactionDate;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getFromAccount() {
//        return fromAccount;
//    }
//
//    public void setFromAccount(int fromAccount) {
//        this.fromAccount = fromAccount;
//    }
//
//    public int getToAccount() {
//        return toAccount;
//    }
//
//    public void setToAccount(int toAccount) {
//        this.toAccount = toAccount;
//    }
//}
