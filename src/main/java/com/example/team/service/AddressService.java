package com.example.team.service;

import com.example.team.entities.Address;
import com.example.team.entities.User;
import com.example.team.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddresses() {
        return this.addressRepository.findAll();
    }

    public List<User> getUsers(Long id) {
        if(addressRepository.findById(id).isPresent()) {
            Address newAddress = addressRepository.findById(id).get();
            List<User> users = newAddress.getUsers();
            return users;
        }
        return null;
    }

    public Address createAddress(Address address) {
        Address newAddress = new Address();
        newAddress.setHouseNo(address.getHouseNo());
        newAddress.setArea(address.getArea());
        newAddress.setPincode(address.getPincode());
        newAddress.setState(address.getState());
        newAddress.setCountry(address.getCountry());
        // Adding user in address
        for(int i=0; i<address.getUsers().size(); i++) {
            newAddress.getUsers().add(address.getUsers().get(i));
        }
        return this.addressRepository.save(newAddress);
    }

    public Address updateAddress(Address address) {
        if(addressRepository.findById(address.getId()).isPresent()) {
            Address newAddress = addressRepository.findById(address.getId()).get();
            newAddress.setHouseNo(address.getHouseNo());
            newAddress.setArea(address.getArea());
            newAddress.setPincode(address.getPincode());
            newAddress.setState(address.getState());
            newAddress.setCountry(address.getCountry());
            return addressRepository.save(newAddress);
        }
        return null;
    }

    public String deleteAddress(Long id) {
        if(addressRepository.findById(id).isPresent()) {
            Address newAddress = addressRepository.findById(id).get();
            addressRepository.deleteById(id);
            return newAddress.toString();
        }
        return "Address does not exist!!!";
    }
}
