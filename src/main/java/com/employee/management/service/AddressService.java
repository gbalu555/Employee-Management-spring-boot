package com.employee.management.service;

import com.employee.management.entity.Address;
import com.employee.management.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address addressDetails) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            address.setStreet(addressDetails.getStreet());
            address.setCity(addressDetails.getCity());
            address.setState(addressDetails.getState());
            address.setZipcode(addressDetails.getZipcode());
            return addressRepository.save(address);
        }
        return null;
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}