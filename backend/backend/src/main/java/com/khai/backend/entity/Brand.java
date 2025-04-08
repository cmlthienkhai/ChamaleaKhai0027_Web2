package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name; // Tên thương hiệu

    @Column(name = "description")
    private String description; // Mô tả về thương hiệu
    
    @Column(name = "image")
    private String image;  // Thêm thuộc tính để lưu tên ảnh

    @OneToMany(mappedBy = "brand")
    private Set<Product> products; // Liên kết với bảng Product (một thương hiệu có thể có nhiều sản phẩm)
}
