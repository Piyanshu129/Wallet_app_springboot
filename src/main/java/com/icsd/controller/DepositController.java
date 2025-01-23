package com.icsd.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icsd.Service.AccountService;
import com.icsd.Service.TransactionService;
import com.icsd.model.Account;
import com.icsd.model.Transaction;
import com.icsd.model.TransactionType;


@RestController
@RequestMapping("/transactions")
public class DepositController {

	
	 @Autowired
	    private TransactionService transactionService;
	    
	    @Autowired
	    private AccountService Accservice;

	    @PostMapping("/deposit/{toAccountId}/{fromAccountId}/{amount}")
	    public Transaction createTransaction(
	            @PathVariable int fromAccountId,
	            @PathVariable int toAccountId,
	            @PathVariable double amount,
	            @RequestBody Transaction transaction) {
	        
	    	
	        //Customer customer = customerService.getCustomerByCustId(custId);

	    	 Account fromAccount = Accservice.getAccByAccId(fromAccountId); // Assuming Account has a constructor with accountId
 Account toAccount = Accservice.getAccByAccId(toAccountId);    
	         
	         Double s3= toAccount.getOpeningBalance();
	     	Double s4=s3+amount;
	     	toAccount.setOpeningBalance(s4);
	         
	    	 System.out.print(fromAccount);
	    	Double s1= fromAccount.getOpeningBalance();
	    	Double s2=s1-amount;
	    	fromAccount.setOpeningBalance(s2);
	        
	         // Assuming Account has a constructor with accountId
	         
	         transaction.setAmount(amount);
	         transaction.setFromAccount(fromAccount.getAccountNo());
	         transaction.setToAccount(toAccount.getAccountNo());
	         transaction.setTransactionDate(LocalDate.now());
	         
	         // Assuming the description is part of the request body transaction object
	         String description = transaction.getDescription();
	         transaction.setDescription(description);
	         transaction.setTransactionType(TransactionType.CREDIT);  // Set transaction type as credit
	         
	         return transactionService.saveTransaction(transaction);
	    }
}
