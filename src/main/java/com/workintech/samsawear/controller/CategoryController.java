package com.workintech.samsawear.controller;

import com.workintech.samsawear.entity.Category;
import com.workintech.samsawear.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }
}
