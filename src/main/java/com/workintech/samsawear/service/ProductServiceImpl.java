package com.workintech.samsawear.service;

import com.workintech.samsawear.entity.Product;
import com.workintech.samsawear.exception.ApiException;
import com.workintech.samsawear.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ApiException("Product with given id doesn't exist", HttpStatus.NOT_FOUND));

    }

    @Override
    public Product delete(Long id) {
        Product productToDelete = findById(id);
        productRepository.delete(productToDelete);
        return productToDelete;
    }


}
