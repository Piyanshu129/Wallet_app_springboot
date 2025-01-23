package com.icsd.controller;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icsd.Service.AccountService;
import com.icsd.common.ApiResponse;
import com.icsd.dto.request.AccountRequestDTO;
import com.icsd.model.Account;
import com.icsd.model.AccountType;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @GetMapping("/{customerId}/accounts")
//    public List<Account> getAccountsByCustomerId(@PathVariable int customerId) {
//        return accountService.getAccountsByCustomerId(customerId);
//        
//        
//        
//    }
//    
    
    
    
    @PostMapping("/createAcc")
    public ResponseEntity<ApiResponse> createAccount(@RequestBody @Valid  AccountRequestDTO accountRequest   )
    {
    	System.out.println(accountRequest);
    	
    	int accountNumber=accountService.saveAccDT(accountRequest);
    	ApiResponse objApiResponse=new ApiResponse(HttpStatus.OK.value(), "account created successfully", accountNumber);
    	return new  ResponseEntity<ApiResponse>(objApiResponse,HttpStatus.OK);
    }
    
   
    
    
    
    
    
    @GetMapping(value="/get/{customerId}")
	public ResponseEntity<ApiResponse> getAllAccountsByCustomerId(@PathVariable int customerId) throws Exception
	{
		//query - should we use custome validation...?
		//log.info("get list of accounts by customer id "+ customerId);
		List<Account> lstAccounts=accountService.getAccountsByCustomerId(customerId);
		
		if(lstAccounts.isEmpty())
		{
			ApiResponse apirsponse=new ApiResponse(HttpStatus.NO_CONTENT.value(), "No Accounts found for customer id "+ customerId, null);
			return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
		}
		ApiResponse apirsponse=new ApiResponse(HttpStatus.FOUND.value(), "list of accounts", lstAccounts);
		
		
		return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
	}
	
    //query= iski naming convention kya hogi
    		//query- @valid not working for path variable - how it will work - not blank is not working 
    		@GetMapping(value="/getAccountsByEmailId/{emailId}")
    		//https://www.baeldung.com/spring-validate-requestparam-pathvariable
    		public ResponseEntity<ApiResponse> getAllAccountsByCustomerEmailId(@PathVariable @Valid @NotBlank(message = "emailId name should not be blank")
    		@NotNull(message="emailId name should not be null")
    		@Email(message="not valid email") String emailId) throws Exception
    		{
    			//query - should we use custome validation...?
    			//log.info("get list of accounts by customer eid "+ emailId);
    			List<Account> lstAccounts=accountService.getAccountsByCustEmailId(emailId);
    			
    			if(lstAccounts.isEmpty())
    			{
    				ApiResponse apirsponse=new ApiResponse(HttpStatus.NO_CONTENT.value(), "No Accounts found for customer emailid "+ emailId, null);
    				return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    			}
    			ApiResponse apirsponse=new ApiResponse(HttpStatus.FOUND.value(), "list of accounts", lstAccounts);
    			
    			
    			return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    		}
    		
    		
    		
    		
    		@GetMapping(value="/findByAccountTypeIn")
    		public ResponseEntity<ApiResponse> findByAccountTypeIn()
    		{
    			//	//select * from account where account_type in ('CURRENT','RD','LOAN');
    			List<AccountType> accTypes=new LinkedList<>();
    			accTypes.add(AccountType.CURRENT);
    			accTypes.add(AccountType.RD);
    			accTypes.add(AccountType.LOAN);
    					List<Account> lst=accountService.findByAccountTypeIn(accTypes);
    					ApiResponse apirespnose=new ApiResponse(HttpStatus.OK.value(), "list of accounts",lst);
    					return new ResponseEntity<ApiResponse>(apirespnose,HttpStatus.OK);
    		}
    		
    		
    		@GetMapping(value="/findByOpeningBalanceNot/{opBal}")
    		public ResponseEntity<ApiResponse> findByOpeningBalanceNot(@PathVariable double opBal)
    		{
    			//where ob<>ipob;
    			List<Account> lst=accountService.findByOpeningBalanceNot(opBal);
    			ApiResponse apirespnose=new ApiResponse(HttpStatus.OK.value(), "list of accounts",lst);
    			return new ResponseEntity<ApiResponse>(apirespnose,HttpStatus.OK);
    		}
    		
    		@GetMapping(value="/findByOrderByOpeningBalanceAsc")
    		public ResponseEntity<ApiResponse> findByOrderByOpeningBalanceAsc()
    		{
    			List<Account> lst=accountService.findByOrderByOpeningBalanceAsc();
    			ApiResponse apirespnose=new ApiResponse(HttpStatus.OK.value(), "list of accounts",lst);
    			return new ResponseEntity<ApiResponse>(apirespnose,HttpStatus.OK);
    		}
    		@GetMapping(value="/findByOpeningDateAfter")
    		public ResponseEntity<ApiResponse> findByOpeningDateAfter()
    		{
    			LocalDate  startDate=LocalDate.of(2024, 6, 1);//yy mm dd
    			
    			List<Account> lst=accountService.findByOpeningDateAfter(startDate);
    			ApiResponse apirespnose=new ApiResponse(HttpStatus.OK.value(), "list of accounts",lst);
    			return new ResponseEntity<ApiResponse>(apirespnose,HttpStatus.OK);
    		}
    		@GetMapping(value="/findByOpeningDateBetween")
    		public ResponseEntity<ApiResponse> findByOpeningDateBetween()
    		{
    			LocalDate  startDate=LocalDate.of(2024, 1, 20);//yy mm dd
    			LocalDate  endDate=LocalDate.of(2024, 6,1);
    			List<Account> lst=accountService.findByOpeningDateBetween(startDate	, endDate);
    			ApiResponse apirespnose=new ApiResponse(HttpStatus.OK.value(), "list of accounts",lst);
    			return new ResponseEntity<ApiResponse>(apirespnose,HttpStatus.OK);
    		}
    		
    		
    		
    		@GetMapping(value="/getAccLesThanOpBal/{opBal}")
    		public ResponseEntity<ApiResponse> getAllAccountsLessThanOpeningBalance(@PathVariable double opBal) throws Exception
    		{

    			//log.info("get list of accounts less than openingbalance "+ opBal);
    			List<Account> lstAccounts=accountService.getAccountsLessThanOpBal(opBal);
    			
    			if(lstAccounts.isEmpty())
    			{
    				ApiResponse apirsponse=new ApiResponse(HttpStatus.NO_CONTENT.value(), "No Accounts , having opbal less than  "+ opBal, null);
    				return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    			}
    			ApiResponse apirsponse=new ApiResponse(HttpStatus.FOUND.value(), "list of accounts", lstAccounts);
    			
    			
    			return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    		}
    		
    		
    		@GetMapping(value="/get/AccLesThanEqualOpBal/{opBal}")
    		public ResponseEntity<ApiResponse> getAllAccountsLessThanEqualOpeningBalance(@PathVariable double opBal) throws Exception
    		{

    			//log.info("get list of accounts less than EQUAL openingbalance "+ opBal);
    			List<Account> lstAccounts=accountService.getAccountsLessThanEqualOpBal(opBal);
    			
    			if(lstAccounts.isEmpty())
    			{
    				ApiResponse apirsponse=new ApiResponse(HttpStatus.NO_CONTENT.value(), "No Accounts , having opbal less than  eQUAL"+ opBal, null);
    				return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    			}
    			ApiResponse apirsponse=new ApiResponse(HttpStatus.FOUND.value(), "list of accounts", lstAccounts);
    			
    			
    			return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    		
    		}
    		@GetMapping(value="/get/findByOpeningBalanceGreaterThan/{opBal}")
    		public ResponseEntity<ApiResponse> findByOpeningBalanceGreaterThan(@PathVariable double opBal) throws Exception
    		{

    			//log.info("get list of accounts greater  than  openingbalance "+ opBal);
    			List<Account> lstAccounts=accountService.findByOpeningBalanceGreaterThan(opBal);
    			
    			if(lstAccounts.isEmpty())
    			{
    				ApiResponse apirsponse=new ApiResponse(HttpStatus.NO_CONTENT.value(), "No Accounts , having opbal greater than  "+ opBal, null);
    				return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    			}
    			ApiResponse apirsponse=new ApiResponse(HttpStatus.FOUND.value(), "list of accounts", lstAccounts);
    			
    			
    			return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    		
    		}
    		@GetMapping(value="/get/findDistinctByAccountTypeAndOpeningBalance/{accType}/{opBal}")
    		public ResponseEntity<ApiResponse> findDistinctByAccountTypeAndOpeningBalance(@PathVariable double opBal,@PathVariable String accType) throws Exception{
//    		{
//    			log.info("loan and opbalance - distinct entry we want ");
//    			log.info("inside findDistinctByAccountTypeAndOpeningBalance accType="+ accType+ " opbal ="+ opBal);
    			AccountType at=null;
    			if(accType.equals("LOAN"))
    			{
    				at=AccountType.LOAN;
    			}
    			else if(accType.equals("SALARY"))
    			{
    				at=AccountType.SALARY;
    			}
    			
    			List<Account> lst=accountService.findDistinctByAccountTypeAndOpeningBalance(at, opBal);
    			if(lst.isEmpty())
    			{
    				ApiResponse apirsponse=new ApiResponse(HttpStatus.NO_CONTENT.value(), "No accournts founds- no record found "+ opBal, null);
    				return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    			}
    			ApiResponse apiresponse =new ApiResponse(HttpStatus.FOUND.value(), "list of accounts", lst);
    			
    			return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.OK);
    		}

    		@GetMapping(value="/get/getDistinctAccType")
    		public ResponseEntity<ApiResponse> getDistinctAccType() throws Exception
    		{
    			//log.info("accType - distinct entry we want ");
    			
    			
    			List<String> lst=accountService.getDistinctAccType();
    			if(lst.isEmpty())
    			{
    				ApiResponse apirsponse=new ApiResponse(HttpStatus.NO_CONTENT.value(), "No accourntType founds- no record found ", null);
    				return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    			}
    			ApiResponse apiresponse =new ApiResponse(HttpStatus.FOUND.value(), "list of accountsType", lst);
    			
    			return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.OK);
    		}

    		@GetMapping(value="/get/findDistinctByOpeningBalance/{opBal}")
    		public ResponseEntity<ApiResponse> findDistinctByOpeningBalance(@PathVariable double opBal) throws Exception
    		{
//    			log.info("opbalance - distinct entry we want ");
//    			log.info("inside findDistinctByOpeningBalance  opbal ="+ opBal);
    			
    			List<Account> lst=accountService.findDistinctByOpeningBalance(opBal);
    			if(lst.isEmpty())
    			{
    				ApiResponse apirsponse=new ApiResponse(HttpStatus.NO_CONTENT.value(), "No accournts founds- no record found "+ opBal, null);
    				return new ResponseEntity<ApiResponse>(apirsponse,HttpStatus.OK);
    			}
    			ApiResponse apiresponse =new ApiResponse(HttpStatus.FOUND.value(), "list of accounts", lst);
    			
    			return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.OK);
    		}

    		
    		
}

