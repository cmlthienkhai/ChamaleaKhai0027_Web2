package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shipping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Liên kết với bảng Order

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress; // Địa chỉ giao hàng

    @Column(name = "shipping_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingDate; // Ngày giao hàng

    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate; // Ngày nhận hàng

    @Column(name = "status", nullable = false)
    private String status; // Trạng thái giao hàng (ví dụ: "Pending", "Shipped", "Delivered")

    @Column(name = "tracking_number")
    private String trackingNumber; // Số theo dõi giao hàng
}
