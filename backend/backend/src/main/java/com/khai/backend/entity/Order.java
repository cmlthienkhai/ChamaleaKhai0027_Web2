package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Liên kết với bảng User

    @Column(name = "order_date", nullable = false)
    private Date orderDate; // Ngày đặt hàng

    @Column(name = "status", nullable = false)
    private String status; // Trạng thái đơn hàng (ví dụ: Pending, Completed)

    @Column(name = "total_price", nullable = false)
    private Double totalPrice; // Tổng tiền đơn hàng

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress; // Địa chỉ giao hàng

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment; // Liên kết với bảng Payment

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails; // Liên kết với bảng OrderDetail
}
