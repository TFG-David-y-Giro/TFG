package org.iesfm.back.controllers;

import org.iesfm.model.pojos.Category;
import org.iesfm.model.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public Category postCategory(@RequestBody Category newCategory) {
        if (categoryService.createCategory(newCategory) == null) {
            categoryService.createCategory(newCategory);
            return newCategory;
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existía");
        }
    }

    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
