package com.khai.backend.service.impl;

import com.khai.backend.entity.Category;
import com.khai.backend.repository.CategoryRepository;
import com.khai.backend.repository.ProductRepository;
import com.khai.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        productRepository.deleteByCategoryId(id); // Xóa tất cả Product liên quan trước
        categoryRepository.deleteById(id); // Sau đó xóa Category
    }
}
