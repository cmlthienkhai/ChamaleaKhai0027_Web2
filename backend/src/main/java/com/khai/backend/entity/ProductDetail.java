package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  // Liên kết với bảng Product

    @Column(name = "size")
    private String size;  // Kích thước của sản phẩm (ví dụ: S, M, L)

    @Column(name = "color")
    private String color;  // Màu sắc của sản phẩm

    @Column(name = "material")
    private String material;  // Chất liệu của sản phẩm

    @Column(name = "weight")
    private Double weight;  // Trọng lượng của sản phẩm

    @Column(name = "stock_quantity")
    private Integer stockQuantity;  // Số lượng tồn kho của sản phẩm chi tiết
}
