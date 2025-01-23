package com.icsd.serviceImpl;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icsd.Exception.ResourceNotFoundException;
import com.icsd.Service.AccountService;
import com.icsd.Service.CustomerService;
import com.icsd.dto.request.AccountRequestDTO;
import com.icsd.model.Account;
import com.icsd.model.AccountType;
import com.icsd.model.Customer;
import com.icsd.repo.AccountRepository;
import com.icsd.repo.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private CustomerRepository custRepo;
    
    @Autowired
    private final CustomerServiceImpl customerService ;//= new CustomerServiceImpl();

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
    
    
    
    
    @Override
    public Account getAccByAccId(int accid) {
        return accountRepository.findById(accid).orElse(null);
    }
    
    
    @Override
    public List<Account> getAccountsByCustomerId(int customerId) {
        return accountRepository.findByCustomer_CustomerId(customerId);
    }




	@Override
	public int saveAccDT(AccountRequestDTO arDTO) {
		// TODO Auto-generated method stub
		Optional<Customer> cust=custRepo.findById(Integer.parseInt( arDTO.getCustomerId()));
		
		if(!cust.isPresent())
		{
			throw new ResourceNotFoundException("customer is not present in db");
		}
		
		Customer objCust= cust.get();
		
		
		Account account=Account.builder().accountType(arDTO.getAccountType()).customer(objCust).
				openingBalance(Double.parseDouble( arDTO.getOpeningBalance())).description(arDTO.getDescription()).openingDate(arDTO.getOpeningDate()).build();
			

	int accNo=	accountRepository.save(account).getAccountNo();
		
		
		return accNo;
	}
	
	@Override
	public int saveAccount(AccountRequestDTO accReq) {
		
		//log.info("create a new account");
		
		Optional<Customer> optionalCust= custRepo.findById(Integer.parseInt(accReq.getCustomerId()));
		if(!optionalCust.isPresent())//If a value is present, returns true, otherwise false.
		{
			//it means customer is not ther in db
			throw new ResourceNotFoundException("Customer is not present in database");
		}
		
		Customer cust=optionalCust.get();
		cust.setCustomerId(Integer.parseInt(accReq.getCustomerId()));
		
		Account account=Account.builder()
				.accountType(accReq.getAccountType())
				.customer(cust).openingBalance(Double.parseDouble(accReq.getOpeningBalance())).description(accReq.getDescription())
				.openingDate(LocalDate.now()).build();
		
		int accNumberCreated=accountRepository.save(account).getAccountNo();
				
				

		
		return accNumberCreated;
	}

	@Override
	public List<Account> getAccountsByCustId(int intCustid) {
		
		//log.info("getting accounts by custid for customer id "+ intCustid);
		//if() -- strcustid - - can have character and in that case it will raise - number format exception
		//how- which one is better method- requestdto par check kaise kare..?
		//int custId=Integer.parseInt(strCustId);
		
		List<Account>  lstAccounts=accountRepository.findByCustomerCustomerId(intCustid);
		if(lstAccounts.isEmpty())
		{
			throw new ResourceNotFoundException("No Account found for customer id "+ intCustid);
		}
		return lstAccounts;
	}

	@Override
	public Account getAccountByAccNumber(int accountNumber) {
		// TODO Auto-generated method stub
		
		Optional<Account> optAcc=accountRepository.findById(accountNumber);
		if(optAcc.isEmpty())
		{
			throw new ResourceNotFoundException("Account is not existing for account number "+ accountNumber);
		}
		return optAcc.get();
		
	}

	@Override
	public List<Account> getAccountsByCustEmailId(String custEmailId)
	{
		Customer cust= customerService.findByEmailId(custEmailId);
		System.out.print(cust);
		List<Account> lst=getAccountsByCustId(cust.getCustomerId());
		// TODO Auto-generated method stub
		return lst;
	}

	@Override
	public List<Account> getAccountsLessThanOpBal(double openingBalance) {
		//log.info("inside  getAccountsLessThanOpBal");
		List<Account> lst=accountRepository.findByOpeningBalanceLessThan(openingBalance);
		return lst;
	}

	@Override
	public List<Account> getAccountsLessThanEqualOpBal(double openingBalance) {
		//log.info("inside  getAccountsLessThanOpBalEqual");
		List<Account> lst=accountRepository.findByOpeningBalanceLessThanEqual(openingBalance);
		return lst;
	}

	@Override
	public List<Account> findDistinctByAccountTypeAndOpeningBalance(AccountType accType, double openingBalance) {
		
		//log.info("inside find distinct By accctype and op balance - accType "+ accType+" op bal= "+ openingBalance);		
		List<Account> lst=	accountRepository.findDistinctByAccountTypeAndOpeningBalance(accType, openingBalance);
		return lst;
		
	}

	@Override
	public List<Account> findDistinctByOpeningBalance(double openingBalance) {
		//log.info("inside find distinct By  op balance - "+ openingBalance);		
		List<Account> lst=	accountRepository.findDistinctByOpeningBalance(openingBalance);
		return lst;
	}

	@Override
	public List<Account> findByOpeningBalanceGreaterThan(double openingBalance) {
		//log.info("inside findByOpeningBalanceGreaterThan - "+ openingBalance);		
		List<Account> lst=	accountRepository.findByOpeningBalanceGreaterThan(openingBalance);
		return lst;
	}

	@Override
	public List<String> getDistinctAccType() {
		//log.info("inside get distinct acc type");
		return  accountRepository.getDistinctAccTypes();
	}

	@Override
	public List<Account> findByOpeningDateBetween(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		//log.info(startDate.toString());
		//log.info(endDate.toString());
		return accountRepository.findByOpeningDateBetween(startDate, endDate);
		//return accountRepo.getAllBetweenDates(new Date(2022, 10, 1), new Date(2022,10,10));
	}

	@Override
	public List<Account> findByOpeningDateAfter(LocalDate dt) {
		// TODO Auto-generated method stub
		return accountRepository.findByOpeningDateAfter(dt);
	}

	@Override
	public List<Account> findByOrderByOpeningBalanceAsc() {
		// TODO Auto-generated method stub
		//return accountRepo.findByOrderByOpeningBalanceAsc();
		return accountRepository.findByOrderByOpeningBalanceDesc();
	}

	@Override
	public List<Account> findByOpeningBalanceNot(double ob) {
		// TODO Auto-generated method stub
		//where x.ob<>ob;
		return accountRepository.findByOpeningBalanceNot(ob);
	}

	@Override
	public List<Account> findByAccountTypeIn(List<AccountType> accTypes) {
		// TODO Auto-generated method stub
		//return accountRepo.findByAccountTypeIn(accTypes);
		return accountRepository.findByAccountTypeNotIn(accTypes);
	}
}
