package com.khai.backend.controller;

import com.khai.backend.entity.Article;
import com.khai.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // Lấy tất cả bài viết
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    // Lấy bài viết theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        return article != null ? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }

    // Lưu bài viết mới
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        return ResponseEntity.ok(articleService.saveArticle(article));
    }

    // Cập nhật bài viết
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        return ResponseEntity.ok(articleService.updateArticle(article));
    }

    // Xóa bài viết
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    // Upload ảnh cho bài viết
    @PostMapping("/{articleId}/upload")
    public ResponseEntity<String> uploadArticleImage(@PathVariable Long articleId, @RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String uploadDir = "images/article"; // Đường dẫn thư mục lưu trữ ảnh trên server

        // Tạo thư mục nếu chưa tồn tại
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            // Lưu file vào thư mục
            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, file.getBytes());

            // Cập nhật tên ảnh vào bảng Article
            Article article = articleService.getArticleById(articleId);
            if (article != null) {
                article.setImage(fileName);  // Lưu tên ảnh vào cột "image"
                articleService.saveArticle(article);  // Cập nhật bài viết
            }

            return ResponseEntity.ok("File uploaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file.");
        }
    }
}
