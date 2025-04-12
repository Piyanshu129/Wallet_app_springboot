package com.icsd.Wallet.mapper;

import com.icsd.Wallet.Model.Address;
import com.icsd.Wallet.dto.AddressDTO;

public class AddressMapper {
    public static AddressDTO toDTO(Address address) {
        return new AddressDTO(
            address.getAddressId(),
            address.getAddressLine1(),
            address.getAddressLine2(),
            address.getCity(),
            address.getState(),
            address.getPincode()
        );
    }

    public static Address toEntity(AddressDTO dto) {
        return new Address(
            dto.getAddressId(),
            dto.getAddressLine1(),
            dto.getAddressLine2(),
            dto.getCity(),
            dto.getState(),
            dto.getPincode()
        );
    }
}

