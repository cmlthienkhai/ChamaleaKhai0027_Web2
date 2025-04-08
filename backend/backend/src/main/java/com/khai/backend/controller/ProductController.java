package com.khai.backend.controller;

import com.khai.backend.entity.Product;
import com.khai.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Thêm mới sản phẩm
    @PostMapping("/")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Lấy tất cả sản phẩm
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Lấy sản phẩm theo mã sản phẩm
    @GetMapping("/{productCode}")
    public ResponseEntity<Product> getProductByProductCode(@PathVariable String productCode) {
        Product product = productService.getProductByProductCode(productCode);
        return product != null ? new ResponseEntity<>(product, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Cập nhật sản phẩm
    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Xóa sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
     // API để tải ảnh sản phẩm
    @PostMapping("/upload/{productId}")
    public ResponseEntity<String> uploadProductImage(@PathVariable Long productId, @RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String uploadDir = "images/product"; // Đường dẫn thư mục lưu trữ ảnh trên server

        // Tạo thư mục nếu chưa tồn tại
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            // Lưu file vào thư mục
            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, file.getBytes());

            // Cập nhật thông tin ảnh vào bảng Product
            Product product = productService.getProductById(productId);
            if (product != null) {
                product.setImage(fileName); // Lưu tên ảnh vào cột "image"
                productService.saveProduct(product);
            }

            return ResponseEntity.ok("File uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file.");
        }
    }
}
