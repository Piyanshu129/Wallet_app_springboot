package com.icsd.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icsd.model.Address;
import com.icsd.repo.AddressRepository;
import com.icsd.Service.AddressService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Data
@Slf4j
public class AddressServiceImpl  implements AddressService
{

	@Autowired
	private final AddressRepository addressRepo;
	@Override
	public Address saveAddress(Address add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddressByAddressId(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findByAddressLine2IsNull() {
		// TODO Auto-generated method stub
		return addressRepo.findByAddressLine2IsNull();
	}

	@Override
	public List<Address> findByAddressLine2IsNotNull() {
		// TODO Auto-generated method stub
		return addressRepo.findByAddressLine2IsNotNull();
	}

}

