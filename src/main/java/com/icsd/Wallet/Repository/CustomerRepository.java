package com.icsd.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icsd.Wallet.Model.Customer;
 

public interface CustomerRepository extends JpaRepository<Customer, Integer> {}