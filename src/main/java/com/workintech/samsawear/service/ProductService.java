package com.workintech.samsawear.service;

import com.workintech.samsawear.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product save(Product product);
    public Product findById(Long id);
    public Product delete(Long id);
}
