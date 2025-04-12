package com.icsd.Wallet.Model;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String transactionType;
    private Date transactionDate;
    private int amount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "fromaccount")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "toaccount")
    private Account toAccount;
}
