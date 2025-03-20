package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;  // Tên danh mục

    @Column(name = "description")
    private String description;  // Mô tả danh mục

    @Column(name = "image")  // Thêm trường này để lưu tên ảnh
    private String image;  // Tên ảnh của danh mục

    @OneToMany(mappedBy = "category")
    private Set<Product> products; 

}
