package com.example.learningbeggining.controllers;


import com.example.learningbeggining.model.Articles;
import com.example.learningbeggining.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticlesController {
    private final ArticleService articleService;

    @Autowired
    public ArticlesController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public String getArticles(Model model) {
        Long userId = getCurrentUserId();
        List<Articles> articlesList = articleService.getArticlesForUser(userId);
        model.addAttribute("articles", articlesList);
        return "articles";
    }

    @PostMapping("/saveArticle")
    public String createArticle(@ModelAttribute Articles article, Model model) {
        Long userId = getCurrentUserId();
        article.setId(userId); // Установить ID пользователя в объекте Articles
        Articles savedArticle = articleService.createArticle(article);
        model.addAttribute("article", savedArticle);
        return "article-created";
    }

    @GetMapping("/create-article")
    public String showCreateForm(Model model) {
        model.addAttribute("article", new Articles());
        return "create-article";
    }

    private Long getCurrentUserId() {
        // Ваша логика для получения текущего пользователя (версия для демонстрации)
        return 1L;
    }
}
