package com.icsd.controller;



import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.icsd.model.Account;
import com.icsd.model.AccountType;
import com.icsd.model.Customer;
import com.icsd.Service.AccountService;
import com.icsd.Service.CustomerService;


@RestController
public class CreatAccount {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/createAccount/{custId}")
    public ResponseEntity<?> createAccount(@RequestBody Account accountRequest, @PathVariable int custId) {
        
        Customer customer = customerService.getCustomerByCustId(custId);

        
        
        if (customer != null) {
            AccountType accountType = accountRequest.getAccountType();
            double openingBalance = accountRequest.getOpeningBalance();
            
            
            LocalDate registrationDate = accountRequest.getOpeningDate() ;
            if (registrationDate == null) {
                registrationDate = LocalDate.now(); // Set current date if null
            }
            
            
            String description = accountRequest.getDescription();

            Account account = new Account();
            account.setCustomer(customer);
            account.setAccountType(accountType);
            account.setOpeningBalance(openingBalance);
            account.setOpeningDate(registrationDate);
            account.setDescription(description);

            Account savedAccount = accountService.saveAccount(account);

            if (savedAccount != null) {
                return ResponseEntity.ok(savedAccount);
            } else {
                return ResponseEntity.status(500).body("Account could not be saved");
            }
        } else {
            return ResponseEntity.status(404).body("Customer not found");
        }
    }
}






























/*
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icsd.model.Account;
import com.icsd.model.AccountType;
import com.icsd.model.Customer;
import com.icsd.Service.AccountService;
import com.icsd.Service.CustomerService;

@RestController
public class CreatAccount {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody 
                                           @RequestParam int custId,
                                           @RequestParam String strAccType,
                                           @RequestParam double openingBalance,
                                           @RequestParam String strOpeningDate,
                                           @RequestParam String description) {

        Customer customer = customerService.getCustomerByCustId(custId);
        if (customer == null) {
            return ResponseEntity.status(404).body("Customer not found");
        }

        AccountType accountType;
        switch (strAccType.toUpperCase()) {
            case "SAVINGS":
                accountType = AccountType.SAVINGS;
                break;
            case "CURRENT":
                accountType = AccountType.CURRENT;
                break;
            case "SALARY":
                accountType = AccountType.SALARY;
                break;
            case "RD":
                accountType = AccountType.RD;
                break;
            case "FD":
                accountType = AccountType.FD;
                break;
            case "LOAN":
                accountType = AccountType.LOAN;
                break;
            default:
                return ResponseEntity.status(400).body("Invalid account type");
        }

        LocalDate openingDate = LocalDate.parse(strOpeningDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Account account = new Account();
        account.setAccountNo(accountNumber);
        account.setCustomer(customer); // Ensure customer is set
        account.setAccountType(accountType);
        account.setOpeningBalance(openingBalance);
        account.setOpeningDate(openingDate);
        account.setDescription(description);

        Account savedAccount = accountService.saveAccount(account);
        if (savedAccount == null) {
            return ResponseEntity.status(500).body("Account not saved");
        } else {
            return ResponseEntity.ok("Account saved successfully");
        }
    }
}

*/

