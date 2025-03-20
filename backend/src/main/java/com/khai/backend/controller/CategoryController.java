package com.khai.backend.controller;

import com.khai.backend.entity.Category;
import com.khai.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.File;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Lấy tất cả danh mục
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Lấy danh mục theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lưu danh mục
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // Cập nhật danh mục
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category existingCategory = categoryService.getCategoryById(id);
        if (existingCategory != null) {
            category.setId(id);
            return ResponseEntity.ok(categoryService.updateCategory(category));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa danh mục
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Category existingCategory = categoryService.getCategoryById(id);
        if (existingCategory != null) {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tìm kiếm danh mục theo tên
    @GetMapping("/search")
    public List<Category> searchCategoriesByName(@RequestParam String name) {
        return categoryService.searchCategoriesByName(name);
    }

    // Tải ảnh danh mục
    @PostMapping("/upload/{categoryId}")
    public ResponseEntity<String> uploadCategoryImage(@PathVariable Long categoryId, @RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String uploadDir = "images/category"; // Đường dẫn thư mục lưu trữ ảnh trên server

        // Tạo thư mục nếu chưa tồn tại
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            // Lưu file vào thư mục
            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, file.getBytes());

            // Cập nhật tên ảnh vào bảng Category
            Category category = categoryService.getCategoryById(categoryId);
            if (category != null) {
                category.setImage(fileName);  // Lưu tên ảnh vào cột "image"
                categoryService.saveCategory(category);  // Cập nhật danh mục
            }

            return ResponseEntity.ok("File uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file.");
        }
    }
}
