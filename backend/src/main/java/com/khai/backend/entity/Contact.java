package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name; // Tên người liên hệ

    @Column(name = "email", nullable = false)
    private String email; // Địa chỉ email của người liên hệ

    @Column(name = "phone", nullable = false)
    private String phone; // Số điện thoại của người liên hệ

    @Column(name = "message", nullable = false)
    private String message; // Tin nhắn hoặc câu hỏi của người liên hệ
}
