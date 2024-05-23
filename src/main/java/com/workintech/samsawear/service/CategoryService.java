package com.workintech.samsawear.service;

import com.workintech.samsawear.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    List<Category> findAll();
    Category delete(Long id);
    Category findById(Long id);
}
