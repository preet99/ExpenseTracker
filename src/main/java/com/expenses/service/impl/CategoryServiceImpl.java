package com.expenses.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expenses.entity.Category;
import com.expenses.repository.CategoryRepository;
import com.expenses.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Category existing = getCategoryById(id);
        existing.setName(updatedCategory.getName());
        existing.setUser(updatedCategory.getUser());
        return categoryRepository.save(existing);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
