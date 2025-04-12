package com.icsd.Wallet.Model;

import java.util.Date;

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
public class Address {
    @Id
    private int addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
    // Getters and Setters
}