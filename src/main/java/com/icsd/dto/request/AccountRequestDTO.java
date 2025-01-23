package com.icsd.dto.request;



import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icsd.model.AccountType;
import com.icsd.model.Customer;
import com.icsd.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//{
//	  "customerId": "123456",
//	  "accountType": "SAVINGS",
//	  "openingBalance": "5000",
//	  "openingDate": "2024-06-13",
//	  "description": "desc"
//	}


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {

//	@NotBlank (message="account number should not be blank")
//	@NotNull(message="account number should not be null")
//	private String accountNumber;
//	
	@NotBlank(message="customer id should not be blank")
	@NotNull(message="customer id should not be null")
	private String customerId;
	
	private AccountType accountType;
	
	@Min(value = 1 ,message = "opening balance should be bw 1-1000000")
	@Max(value=1000000 ,message = "opening balance should be between 1-1000000")
	
	private String openingBalance;
	
		   
	private LocalDate   openingDate=LocalDate.now();//openingDate
	
	private String description="desc";
	
	
}
