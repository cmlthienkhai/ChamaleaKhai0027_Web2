package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore  // Tránh vòng lặp vô hạn khi trả dữ liệu JSON
    private Set<Product> products;
}
