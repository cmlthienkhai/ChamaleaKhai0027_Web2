package com.khai.backend.controller;

import com.khai.backend.entity.Brand;
import com.khai.backend.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    // Lấy tất cả các brand
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    // Lấy brand theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        Brand brand = brandService.getBrandById(id);
        if (brand != null) {
            return ResponseEntity.ok(brand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lưu brand
    @PostMapping
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.saveBrand(brand);
    }

    // Cập nhật brand
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        Brand existingBrand = brandService.getBrandById(id);
        if (existingBrand != null) {
            brand.setId(id);
            return ResponseEntity.ok(brandService.updateBrand(brand));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa brand
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        Brand existingBrand = brandService.getBrandById(id);
        if (existingBrand != null) {
            brandService.deleteBrand(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tìm kiếm brand theo tên
    @GetMapping("/search")
    public List<Brand> searchBrandsByName(@RequestParam String name) {
        return brandService.searchBrandsByName(name);
    }

    // Tải ảnh của brand
    @PostMapping("/upload/{brandId}")
    public ResponseEntity<String> uploadBrandImage(@PathVariable Long brandId, @RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String uploadDir = "images/brand";  // Đường dẫn thư mục lưu trữ ảnh trên server

        // Tạo thư mục nếu chưa tồn tại
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            // Lưu file vào thư mục
            Path path = Path.of(uploadDir + fileName);
            Files.write(path, file.getBytes());

            // Cập nhật tên ảnh vào bảng Brand
            Brand brand = brandService.getBrandById(brandId);
            if (brand != null) {
                brand.setImage(fileName);  // Lưu tên ảnh vào cột "image"
                brandService.saveBrand(brand);  // Cập nhật brand
            }

            return ResponseEntity.ok("File uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file.");
        }
    }
}
