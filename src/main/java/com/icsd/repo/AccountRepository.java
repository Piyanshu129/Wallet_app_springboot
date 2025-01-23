package com.icsd.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icsd.model.Account;
import com.icsd.model.AccountType;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	
    List<Account> findByCustomer_CustomerId(int customerId);
	List<Account> findByCustomerCustomerId(int custid);
	 // findByCountryId(String countryId);
	// List<Apple> findByAppleIdLessThan(Long appleId);
	List<Account> findByOpeningBalanceLessThan(double ob);
	List<Account> findByOpeningBalanceGreaterThan(double ob);
	List<Account> findByOpeningBalanceLessThanEqual(double ob);
	List<Account> findDistinctByAccountTypeAndOpeningBalance(AccountType accType,double openingBalance);
	List<Account> findDistinctByOpeningBalance(double openingBalance);
	//List<Account> findByTitleLike(String title);
	
	 @Query(value = "select DISTINCT(a.accountType) from Account a")
	  List<String> getDistinctAccTypes();
	 	
	List<Account> findByOpeningDateBetween(LocalDate start, LocalDate end);
	List<Account> findByOpeningDateAfter(LocalDate dt);
	
	List<Account>  findByOrderByOpeningBalanceAsc();
	List<Account>  findByOrderByOpeningBalanceDesc();
	//List<Account>  findByOpeningBalanceOrderByLastnameDesc();
	List<Account> findByOpeningBalanceNot(double ob);
	//select * from account where account_type in ('CURRENT','RD','LOAN');
	List<Account> findByAccountTypeIn(List<AccountType> accTypes);
	List<Account> findByAccountTypeNotIn(List<AccountType> accTypes);
}
