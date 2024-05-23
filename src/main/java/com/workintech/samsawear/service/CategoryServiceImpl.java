package com.workintech.samsawear.service;

import com.workintech.samsawear.entity.Category;
import com.workintech.samsawear.exception.ApiException;
import com.workintech.samsawear.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ApiException("Category with given id doesnt exist!", HttpStatus.NOT_FOUND));
    }

    @Override
    public Category delete(Long id) {
        Category categoryToDelete = findById(id);
        categoryRepository.delete(categoryToDelete);
        return categoryToDelete;
    }
}
