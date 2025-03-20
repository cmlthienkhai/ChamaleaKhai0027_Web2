package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Liên kết với bảng User

    @ManyToOne
    @JoinColumn(name = "product_detail_id", nullable = false)
    private ProductDetail productDetail; // Liên kết với bảng ProductDetail

    @Column(name = "quantity", nullable = false)
    private Integer quantity; // Số lượng sản phẩm trong giỏ

    @Column(name = "original_price", nullable = false)
    private Double originalPrice; // Giá gốc của sản phẩm

    @Column(name = "final_price", nullable = false)
    private Double finalPrice; // Giá sau giảm của sản phẩm

    @Column(name = "total_price", nullable = false)
    private Double totalPrice; // Tổng tiền cho số lượng sản phẩm trong giỏ
}
