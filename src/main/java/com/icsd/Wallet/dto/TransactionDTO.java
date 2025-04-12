package com.icsd.Wallet.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private int transactionId;
    private String transactionType;
    private Date transactionDate;
    private int amount;
    private String description;
    private int fromAccount;
    private int toAccount;
    // Getters and Setters
}
