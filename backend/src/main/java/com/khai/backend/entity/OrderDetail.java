package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Liên kết với bảng Order

    @ManyToOne
    @JoinColumn(name = "product_detail_id", nullable = false)
    private ProductDetail productDetail; // Liên kết với bảng ProductDetail

    @Column(name = "quantity", nullable = false)
    private Integer quantity; // Số lượng sản phẩm trong chi tiết đơn hàng

    @Column(name = "original_price", nullable = false)
    private Double originalPrice; // Giá gốc của sản phẩm trong chi tiết đơn hàng

    @Column(name = "final_price", nullable = false)
    private Double finalPrice; // Giá sản phẩm sau giảm giá

    @Column(name = "total_price", nullable = false)
    private Double totalPrice; // Tổng giá trị của sản phẩm trong chi tiết đơn hàng
}
