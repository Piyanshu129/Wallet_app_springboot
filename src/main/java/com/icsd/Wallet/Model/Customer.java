package com.icsd.Wallet.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int customerId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String contactNo;
    private int addressId;
    private String gender;
    private String pwd;
    private Date registrationDate;
}