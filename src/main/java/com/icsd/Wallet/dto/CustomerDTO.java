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
public class CustomerDTO {
    private int customerId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String contactNo;
    private int addressId;
    private String gender;
    private String pwd;
    private Date registrationDate;
    // Getters and Setters
}
