package com.workintech.samsawear.controller;

import com.workintech.samsawear.entity.Category;
import com.workintech.samsawear.entity.Product;
import com.workintech.samsawear.service.CategoryService;
import com.workintech.samsawear.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("/{categoryId}")
    public Product save(@RequestBody Product product, @PathVariable Long categoryId){
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);

        category.addProduct(product);
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id){
        return productService.delete(id);
    }


}
