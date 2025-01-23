package com.icsd.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icsd.model.Customer;

import jakarta.servlet.http.HttpSession;

import com.icsd.Service.CustomerService;

@RestController
public class AuthController {

	
    @Autowired
    private CustomerService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> authenticateCustomer(@RequestBody Customer authRequest, HttpSession session) {
    	System.out.println(authRequest);
    	//       emailId=ps129@example.com, contactNo=null, address=null, gender=null, password=piyanshu123,
    	
    	
        boolean isValid = authService.isValidCustByEmailidAndPwd(authRequest.getEmailId(), authRequest.getPassword());
        
       
        if (isValid==true) {
            Customer customer = authService.getCustomerByEmailidAndPwd(authRequest.getEmailId());
            
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }
    }

 }
