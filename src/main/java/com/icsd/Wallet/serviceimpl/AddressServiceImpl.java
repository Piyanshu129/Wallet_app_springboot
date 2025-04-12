package com.icsd.Wallet.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icsd.Wallet.Model.Address;
import com.icsd.Wallet.Repository.AddressRepository;
import com.icsd.Wallet.dto.AddressDTO;
import com.icsd.Wallet.mapper.AddressMapper;
import com.icsd.Wallet.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public AddressDTO createAddress(AddressDTO dto) {
        return AddressMapper.toDTO(addressRepo.save(AddressMapper.toEntity(dto)));
    }

    @Override
    public AddressDTO getAddressById(int id) {
        return addressRepo.findById(id).map(AddressMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Address not found with ID: " + id));
    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        return addressRepo.findAll().stream().map(AddressMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public AddressDTO updateAddress(int id, AddressDTO dto) {
        Address address = AddressMapper.toEntity(dto);
        address.setAddressId(id);
        return AddressMapper.toDTO(addressRepo.save(address));
    }

    @Override
    public void deleteAddress(int id) {
        addressRepo.deleteById(id);
    }
}
