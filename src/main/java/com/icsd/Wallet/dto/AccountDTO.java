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
public class AccountDTO {
    private int accountNumber;
    private int customerId;
    private String accountType;
    private double openingBalance;
    private String description;
    private Date openingDate;
    // Getters and Setters
}