package org.iesfm.model.services;

import org.iesfm.model.pojos.Category;
import org.iesfm.model.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategory(int id) {
        if (categoryRepository.existsById(id)) {
            return categoryRepository.getById(id);
        } else {
            return null;
        }
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            return null;
        } else {
            categoryRepository.save(category);
            return category;
        }
    }
}
