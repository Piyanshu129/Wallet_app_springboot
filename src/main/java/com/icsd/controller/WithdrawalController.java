package com.icsd.controller;

import com.icsd.Service.AccountService;
import com.icsd.Service.TransactionService;
import com.icsd.model.Account;
import com.icsd.model.Customer;
import com.icsd.model.Transaction;
import com.icsd.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/transactions")
public class WithdrawalController {

    @Autowired
    private TransactionService transactionService;
    
    @Autowired
    private AccountService Accservice;

    @PostMapping("/withdraw/{fromAccountId}/{toAccountId}/{amount}")
    public Transaction createTransaction(
            @PathVariable int fromAccountId,
            @PathVariable int toAccountId,
            @PathVariable double amount,
            @RequestBody Transaction transaction) {
        
    	
        //Customer customer = customerService.getCustomerByCustId(custId);

    	 Account fromAccount = Accservice.getAccByAccId(fromAccountId); // Assuming Account has a constructor with accountId
    	 
    	 System.out.println(fromAccount);
    	Double s1= fromAccount.getOpeningBalance();
    	Double s2=s1-amount;
    	fromAccount.setOpeningBalance(s2);
         Account toAccount = Accservice.getAccByAccId(toAccountId);    
         
         Double s3= toAccount.getOpeningBalance();
     	Double s4=s3+amount;
     	toAccount.setOpeningBalance(s4);
         
         // Assuming Account has a constructor with accountId
         
         transaction.setAmount(amount);
         transaction.setFromAccount(fromAccount.getAccountNo());
         transaction.setToAccount(toAccount.getAccountNo());
         transaction.setTransactionDate(LocalDate.now());
         
         // Assuming the description is part of the request body transaction object
         String description = transaction.getDescription();
         transaction.setDescription(description);
         transaction.setTransactionType(TransactionType.DEBIT);  // Set transaction type as debit
         
         return transactionService.saveTransaction(transaction);
    }
}
