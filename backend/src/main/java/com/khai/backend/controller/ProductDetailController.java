package com.khai.backend.controller;

import com.khai.backend.entity.ProductDetail;
import com.khai.backend.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-details")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    // Lấy tất cả chi tiết sản phẩm
    @GetMapping
    public List<ProductDetail> getAllProductDetails() {
        return productDetailService.getAllProductDetails();
    }

    // Lấy chi tiết sản phẩm theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetail> getProductDetailById(@PathVariable Long id) {
        Optional<ProductDetail> productDetail = productDetailService.getProductDetailById(id);
        return productDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lưu chi tiết sản phẩm
    @PostMapping
    public ProductDetail createProductDetail(@RequestBody ProductDetail productDetail) {
        return productDetailService.saveProductDetail(productDetail);
    }

    // Cập nhật chi tiết sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<ProductDetail> updateProductDetail(@PathVariable Long id, @RequestBody ProductDetail productDetail) {
        Optional<ProductDetail> existingProductDetail = productDetailService.getProductDetailById(id);
        if (existingProductDetail.isPresent()) {
            productDetail.setId(id);
            return ResponseEntity.ok(productDetailService.updateProductDetail(productDetail));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa chi tiết sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductDetail(@PathVariable Long id) {
        Optional<ProductDetail> existingProductDetail = productDetailService.getProductDetailById(id);
        if (existingProductDetail.isPresent()) {
            productDetailService.deleteProductDetail(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tìm chi tiết sản phẩm theo product_id
    @GetMapping("/product/{productId}")
    public List<ProductDetail> getProductDetailsByProductId(@PathVariable Long productId) {
        return productDetailService.getProductDetailsByProductId(productId);
    }

    // Tìm chi tiết sản phẩm theo kích thước
    @GetMapping("/size/{size}")
    public List<ProductDetail> getProductDetailsBySize(@PathVariable String size) {
        return productDetailService.getProductDetailsBySize(size);
    }

    // Tìm chi tiết sản phẩm theo màu sắc
    @GetMapping("/color/{color}")
    public List<ProductDetail> getProductDetailsByColor(@PathVariable String color) {
        return productDetailService.getProductDetailsByColor(color);
    }

    // Tìm chi tiết sản phẩm theo kích thước và màu sắc
    @GetMapping("/size/{size}/color/{color}")
    public List<ProductDetail> getProductDetailsBySizeAndColor(@PathVariable String size, @PathVariable String color) {
        return productDetailService.getProductDetailsBySizeAndColor(size, color);
    }
}
