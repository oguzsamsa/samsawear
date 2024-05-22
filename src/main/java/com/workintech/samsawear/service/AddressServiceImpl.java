package com.workintech.samsawear.service;

import com.workintech.samsawear.entity.Address;
import com.workintech.samsawear.exception.ApiException;
import com.workintech.samsawear.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional.orElseThrow(() -> new ApiException("Address with given id doesn't exist!", HttpStatus.NOT_FOUND));
    }

    @Override
    public Address delete(long id) {
        Address addressToDelete = findById(id);
        addressRepository.delete(addressToDelete);
        return addressToDelete;
    }
}
