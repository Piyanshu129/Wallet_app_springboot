package com.icsd.Wallet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.icsd.Wallet.dto.AddressDTO;
import com.icsd.Wallet.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO dto) {
        return ResponseEntity.ok(addressService.createAddress(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> get(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAll() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable int id, @RequestBody AddressDTO dto) {
        return ResponseEntity.ok(addressService.updateAddress(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}

