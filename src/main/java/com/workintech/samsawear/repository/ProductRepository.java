package com.workintech.samsawear.repository;

import com.workintech.samsawear.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //TODO -> add some sorting methods

}
