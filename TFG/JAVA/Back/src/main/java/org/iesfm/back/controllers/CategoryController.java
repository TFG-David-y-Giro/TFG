package org.iesfm.back.controllers;

import org.iesfm.model.pojos.Category;
import org.iesfm.model.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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
        } else if (categoryService.getCategoriesNames().contains(newCategory.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existía el nombre");
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existía el id");
        }
    }

    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/names")
    public List<String> getCategoriesNames() {return categoryService.getCategoriesNames();}


    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable int id) {
            return categoryService.getCategory(id);
    }

    @PutMapping("/category/{id}")
    public Category putCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
        if (categoryService.getCategory(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontrado");
        } else {
            categoryService.putCategory(id, updatedCategory);
            return updatedCategory;
        }
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable int id) {
        if (categoryService.getCategory(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontrado");
        } else {
            categoryService.deleteCategory(id);
        }
    }
}
