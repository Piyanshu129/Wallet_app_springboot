package com.icsd.Wallet.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    private int accountNumber;
    private int customerId;
    private String accountType;
    private double openingBalance;
    private String description;
    private Date openingDate;
    // Getters and Setters
}
