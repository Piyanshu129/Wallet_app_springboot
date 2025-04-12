package com.icsd.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icsd.Wallet.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {}

