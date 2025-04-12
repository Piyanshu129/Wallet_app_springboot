package com.icsd.Wallet.service;

import java.util.List;

import com.icsd.Wallet.dto.AddressDTO;

public interface AddressService {
    AddressDTO createAddress(AddressDTO dto);
    AddressDTO getAddressById(int id);
    List<AddressDTO> getAllAddresses();
    AddressDTO updateAddress(int id, AddressDTO dto);
    void deleteAddress(int id);
}
