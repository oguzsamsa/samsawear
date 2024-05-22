package com.workintech.samsawear.service;

import com.workintech.samsawear.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address save(Address address);
    Address findById(long id);
    Address delete(long id);
}
