package com.icsd.Service;

import java.util.List;

import com.icsd.dto.request.CustomerLoginDTO;
import com.icsd.dto.request.CustomerRequestDto;
import com.icsd.dto.response.CustomerFnmLnmGenderDTO;
import com.icsd.model.Address;
import com.icsd.model.Customer;

import jakarta.validation.Valid;

public interface CustomerService {

	
	Address saveAddress(Address address);
   
    public boolean isValidCustByEmailidAndPwd(String email, String password);
    public Customer getCustomerByEmailidAndPwd(String email);
	Customer getCustomerByCustId(int custId);
    
	
	
	
	
	
	public boolean isValidCustByEmailidAndPwd(CustomerLoginDTO customerlogin);
	public Customer saveCustomer(Customer cust);
	public Customer getCustomerByEmailid(String strEmailId);
	public Customer getCustomerByCustId(String strCustId);
	public Integer createCustomer(@Valid CustomerRequestDto customerRequest);
	public List<Customer> findByFirstNameLike(String fn);
	List<Customer> findByFirstNameContaining(String fnm);
	List<Customer> findByfirstNameContains(String fnm);
	List<Customer> findByfirstNameIsContaining(String fnm);
	List<Customer> findByFirstNameIgnoreCase(String fn);
	//List<CustomerFnmLnmGenderDTO> findByLastName(String lnm);
	Boolean existsByEmailIdAndPassword(String email, String password);
	
	Customer registerCustomer(Customer customer);

    Customer getCustomerByEmailAndPassword(String email, String password);

//    Customer createCustomer(@Valid CustomerRequestDto customerRequest) throws SchedulerException;

    Boolean isCustomerExistsByID(int customerID);

    Customer getCustomerByEmailId(String strEmailId);

    Customer getCustomerByCustomerId(int strCustomerId);

    List<Customer> getCustomerExpiringTodayOrTomorrow();

	List<CustomerFnmLnmGenderDTO> findByLastName(String lnm);

//    InputStreamResource CreateSampleSheet() throws IOException;
//
//
//    ArrayList<String> sendBulkData(MultipartFile multipartFile) throws IOException, InvalidFormatException, SchedulerException;
//
//    Document CreateCustomerPDF(int customerId, HttpServletResponse response) throws IOException;
//
//    ArrayList<String> sheetCalc(XSSFSheet sheet) throws SchedulerException;
}
