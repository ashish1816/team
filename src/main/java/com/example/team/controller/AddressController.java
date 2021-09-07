package com.example.team.controller;

import com.example.team.entities.Address;
import com.example.team.entities.User;
import com.example.team.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> getAddresses() {
        return this.addressService.getAddresses();
    }

    @GetMapping("/addresses/{id}/users-info")
    public List<User> getUsers(@PathVariable Long id) {
        return this.addressService.getUsers(id);
    }

    @PostMapping("/addresses")
    public Address createAddress(@RequestBody Address address) {
        return this.addressService.createAddress(address);
    }

    @PutMapping("/addresses")
    public Address updateAddress(@RequestBody Address address) {
        return this.addressService.updateAddress(address);
    }

    @DeleteMapping("/addresses/{id}")
    public String deleteAddress(@PathVariable Long id) {
        return this.addressService.deleteAddress(id);
    }


}
