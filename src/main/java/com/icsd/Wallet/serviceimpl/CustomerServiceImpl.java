package com.icsd.Wallet.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icsd.Wallet.Repository.CustomerRepository;
import com.icsd.Wallet.dto.CustomerDTO;
import com.icsd.Wallet.mapper.CustomerMapper;
import com.icsd.Wallet.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired 
    private CustomerRepository repository;

	@Override
    public CustomerDTO getCustomerById(int id) { return CustomerMapper.toDTO(repository.findById(id).orElseThrow()); }


	@Override
    public List<CustomerDTO> getAllCustomers() { return repository.findAll().stream().map(CustomerMapper::toDTO).toList(); }


	@Override
    public CustomerDTO saveCustomer(CustomerDTO dto) { return CustomerMapper.toDTO(repository.save(CustomerMapper.toEntity(dto))); }


	@Override
    public void deleteCustomer(int id) { repository.deleteById(id); }

   
}
