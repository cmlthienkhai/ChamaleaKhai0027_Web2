package com.khai.backend.service;

import com.khai.backend.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();
    
    Article getArticleById(Long id);
    
    Article saveArticle(Article article);
    
    Article updateArticle(Article article);
    
    void deleteArticle(Long id);
}
