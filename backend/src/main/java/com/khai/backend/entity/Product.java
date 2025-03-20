package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode;  // Mã sản phẩm

    @Column(name = "name", nullable = false)
    private String name;  // Tên sản phẩm

    @Column(name = "image")  // Cột để lưu tên hoặc URL ảnh sản phẩm
    private String image; 
    
    @Column(name = "description")
    private String description;  // Mô tả sản phẩm

    @Column(name = "original_price", nullable = false)
    private BigDecimal originalPrice;  // Giá gốc sản phẩm

    @Column(name = "discount_price")
    private BigDecimal discountPrice;  // Giá giảm của sản phẩm

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;  // Số lượng sản phẩm trong kho

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;  // Liên kết với bảng Category

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;  // Liên kết với bảng Brand
}
