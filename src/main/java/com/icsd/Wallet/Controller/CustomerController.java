package com.icsd.Wallet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icsd.Wallet.dto.CustomerDTO;
import com.icsd.Wallet.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired private CustomerService service;
    @GetMapping("/{id}") 
    public CustomerDTO getCustomer(@PathVariable int id) { return service.getCustomerById(id); }
    @GetMapping 
    public List<CustomerDTO> getAll() { return service.getAllCustomers(); }
    @PostMapping 
    public CustomerDTO create(@RequestBody CustomerDTO dto) { return service.saveCustomer(dto); }
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable int id) { service.deleteCustomer(id); }
}
