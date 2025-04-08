package com.khai.backend.repository;

import com.khai.backend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByStatus(String status); // Tìm bài viết theo trạng thái (ví dụ: "published")
    Optional<Article> findByTitle(String title); // Tìm bài viết theo tiêu đề
}
