package com.icsd.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

@Entity
@SequenceGenerator(initialValue = 100, name = "accno", sequenceName = "accno")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accno")
    private int accountNo;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double openingBalance;

    private LocalDate openingDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "customerfkk")
    @JsonIgnore
    private Customer customer;

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", openingBalance=" + openingBalance
				+ ", openingDate=" + openingDate + ", description=" + description + "]";
	}
    
    
    
}



//@Entity
//@SequenceGenerator(initialValue = 100, name = "accno", sequenceName = "accno")
//public class Account {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accno")
//    private int accountNo;
//
//    @Enumerated(EnumType.STRING)
//    private AccountType accountType;
//
//    private double openingBalance;
//
//    private LocalDate openingDate;
//
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "customerfkk")
//    @JsonIgnore
//    private Customer customer;
//
//    // Getters and Setters
//
//    public int getAccountNo() {
//        return accountNo;
//    }
//
//    public void setAccountNo(int accountNo) {
//        this.accountNo = accountNo;
//    }
//
//    public AccountType getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(AccountType accountType) {
//        this.accountType = accountType;
//    }
//
//    public double getOpeningBalance() {
//        return openingBalance;
//    }
//
//    public void setOpeningBalance(double openingBalance) {
//        this.openingBalance = openingBalance;
//    }
//
//    public LocalDate getOpeningDate() {
//        return openingDate;
//    }
//
//    public void setOpeningDate(LocalDate openingDate) {
//        this.openingDate = openingDate;
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
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//}
