package com.icsd.Wallet.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private int addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
    // Getters and Setters
}
