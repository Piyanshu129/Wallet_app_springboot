package com.icsd.serviceImpl;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icsd.Exception.ResourceNotFoundException;
import com.icsd.Service.CustomerService;
import com.icsd.dto.request.CustomerLoginDTO;
import com.icsd.dto.request.CustomerRequestDto;
import com.icsd.dto.response.CustomerFnmLnmGenderDTO;
import com.icsd.model.Address;
import com.icsd.model.Customer;
import com.icsd.repo.AddressRepository;
import com.icsd.repo.CustomerRepository;

import jakarta.validation.Valid;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    
    
    @Override
    public Customer getCustomerByCustId(int custId) {
        return customerRepository.findById(custId).orElse(null);
    }
    
    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    @Override
    public boolean isValidCustByEmailidAndPwd(String email, String password) {
        return customerRepository.existsByEmailIdAndPassword(email, password);
    }

    @Override
    public Customer getCustomerByEmailidAndPwd(String email) {
        return customerRepository.findByEmailId(email);
    }

    public Customer findByEmailId(String custEmailId) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmailId(custEmailId);
	}
    
    @Override
	public Customer getCustomerByCustId(String strCustId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer createCustomer(@Valid CustomerRequestDto crDto) {
		//log.info("Inside save customer of service with given request"+crDto);
		System.out.println("inside save customer of service with given request "+ crDto);
		//step 1 : validate 
		
		Customer optCust=customerRepository.findByEmailId(crDto.getEmailId());
		if(optCust!=null)
		{
			//email id is already present
			throw new ResourceNotFoundException("Customer email id is already existing ");
		}
		
		//step 2 : convert dto to entity
		Address add=Address.builder().addressLine1(crDto.getAddressLine1())
				.addressLine2(crDto.getAddressLine2())
				.city(crDto.getCity())
				.state(crDto.getState())
				.pincode(crDto.getPincode())
				.build();
	
		Address addCreated=addressRepository.save(add);
		
		
		Customer cust=Customer.builder().firstName(crDto.getFirstName()).lastName(crDto.getLastName()).emailId(crDto.getEmailId())
				.contactNo(crDto.getContactNo()).address(addCreated).gender(crDto.getGender()).password(crDto.getPassword()).confirmPassword(crDto.getConfirmPassword()).registerationDate(LocalDate.now()).build();
		System.out.println("cust entity is now from builder : "+ cust);
		//log.info("Cust enttity saved",cust);;
		Customer custCreated=customerRepository.save(cust);
		
		//step 3 : save entity and send response
		
		
		return custCreated.getCustomerId();
		//return 100;
	}

	@Override
	public List<Customer> findByFirstNameLike(String fn) {
		
		//log.info("inside List<Customer> findByFirstNameLike(String fn)");
		//List<Customer> lst=customerRepo.findByFirstNameLike("%"+fn+"%");- 
		/*
		 * //	List<Customer> findByFirstNameContaining(String fnm);
//	List<Customer> findByfirstNameContains(String fnm);
//	List<Customer> findByfirstNameIsContaining(String fnm);
 * same as like findByFirstNameLike("%"+fn+"%")*/
		
	//	List<Customer> lst=customerRepo.findByFirstNameLike("%"+fn);//t in last ex scott-ex %t
		List<Customer> lst=customerRepository.findByFirstNameLike(fn+"%");//t in last ex smith,scott-ex s%
		
		return lst;
	}

	@Override
	public List<Customer> findByFirstNameContaining(String fnm) {
		
		List <Customer> lst=customerRepository.findByfirstNameIsContaining(fnm);
		return lst;
	}

	@Override
	public List<Customer> findByfirstNameContains(String fnm) {
		List <Customer> lst=customerRepository.findByfirstNameContains(fnm);
		return lst;
	}

	@Override
	public List<Customer> findByfirstNameIsContaining(String fnm) {
		List <Customer> lst=customerRepository.findByfirstNameIsContaining(fnm);
		return lst;
	}
	public List<Customer> findByFirstNameIgnoreCase(String fn)
	{
		List <Customer> lst=customerRepository.findByFirstNameIgnoreCase(fn);
		return lst;
	}
	
	public Boolean existsByEmailIdAndPassword(String email, String password)
	{
		return customerRepository.existsByEmailIdAndPassword(email, password);
		
	}

	@Override
	public boolean isValidCustByEmailidAndPwd(CustomerLoginDTO customerlogin) {
		
		boolean res=true;
		Customer optCust=customerRepository.findByEmailIdAndPassword(customerlogin.getEmailId(), customerlogin.getPassword());
		
		if(optCust==null)
		{
			res=false;
			throw new ResourceNotFoundException("customer is not existing for email id "+ customerlogin.getEmailId() + " and pwd= "+ customerlogin.getPassword());
		}
		
		return res;
	}

	@Override
	public Customer getCustomerByEmailid(String strEmailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isCustomerExistsByID(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByEmailId(String strEmailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByCustomerId(int strCustomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomerExpiringTodayOrTomorrow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerFnmLnmGenderDTO> findByLastName(String lnm)
	{
		
		List <CustomerFnmLnmGenderDTO> lst=customerRepository.findByLastName(lnm);
		return lst;
	}
    
    
//    @Override
//    public boolean isValidCustByEmailidAndPwd(String email, String password) {
//        List<Customer> customers = customerRepository.findByEmailIdAndPassword(email, password);
//        return customers.size() == 1;
//    }
//
//    @Override
//    public Customer getCustomerByEmailidAndPwd(String email) {
//        List<Customer> customers = customerRepository.findByEmailIdAndPassword(email, null); // Password should not be null
//        return customers.isEmpty() ? null : customers.get(0);
//    }
}


