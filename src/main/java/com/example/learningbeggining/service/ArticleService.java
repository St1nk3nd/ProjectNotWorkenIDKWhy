package com.example.learningbeggining.service;


import com.example.learningbeggining.model.Articles;
import com.example.learningbeggining.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    public Articles createArticle(Articles article) {
        Long userId = article.getId();
        // Генерация уникального articleNumber
        Long articleNumber = generateUniqueArticleNumber(userId);

        // Установка articleNumbera
        article.setArticleNumber(articleNumber);

        // Сохранение статьи в репозитории и возврат сохраненного объекта
        return articleRepository.save(article);
    }

    public List<Articles> getArticlesForUser(Long userId) {
        return articleRepository.findByUserId(userId);
    }

    private Long generateUniqueArticleNumber(Long userId) {
        Optional<Articles> lastArticle = articleRepository.findFirstByUserIdOrderByArticleNumberDesc(userId);
        return lastArticle.map(article -> article.getArticleNumber() + 1).orElse(1L);
    }
}
