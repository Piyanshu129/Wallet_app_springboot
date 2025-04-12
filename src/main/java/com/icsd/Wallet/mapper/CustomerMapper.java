package com.icsd.Wallet.mapper;

import com.icsd.Wallet.Model.Customer;
import com.icsd.Wallet.dto.CustomerDTO;

public class CustomerMapper {
    public static CustomerDTO toDTO(Customer customer) {
        
      return new CustomerDTO(customer.getCustomerId(),customer.getFirstName(),customer.getLastName(),customer.getEmailId(),customer.getContactNo(),customer.getAddressId(),customer.getPwd(),customer.getGender(),customer.getRegistrationDate()) ;
    }
    public static Customer toEntity(CustomerDTO dto) {
        
        return new Customer(dto.getCustomerId(),dto.getFirstName(),dto.getLastName(),dto.getEmailId(),dto.getContactNo(),dto.getAddressId(),dto.getPwd(),dto.getGender(),dto.getRegistrationDate());
    }
}
