package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title; // Tiêu đề bài viết

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content; // Nội dung bài viết

    @Column(name = "author", nullable = false)
    private String author; // Tác giả bài viết

    @Column(name = "published_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate; // Ngày xuất bản bài viết

    @Column(name = "status")
    private String status; 
    
    @Column(name = "image")
    private String image; 
}
