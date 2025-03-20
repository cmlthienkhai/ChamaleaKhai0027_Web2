package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Liên kết với bảng Order

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod; // Phương thức thanh toán (ví dụ: thẻ tín dụng, PayPal, v.v.)

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus; // Trạng thái thanh toán (ví dụ: Đã thanh toán, Chưa thanh toán)

    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate; // Ngày thanh toán

    @Column(name = "amount_paid", nullable = false)
    private Double amountPaid; // Số tiền thanh toán

    @Column(name = "transaction_id", nullable = false)
    private String transactionId; // Mã giao dịch (có thể từ hệ thống thanh toán bên thứ ba)
}
