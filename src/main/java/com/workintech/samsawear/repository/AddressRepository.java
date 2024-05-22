package com.workintech.samsawear.repository;

import com.workintech.samsawear.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
