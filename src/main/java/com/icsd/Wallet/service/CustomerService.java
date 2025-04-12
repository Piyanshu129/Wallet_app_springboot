package com.icsd.Wallet.service;

import java.util.List;

import com.icsd.Wallet.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO getCustomerById(int id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO saveCustomer(CustomerDTO customer);
    void deleteCustomer(int id);
}
