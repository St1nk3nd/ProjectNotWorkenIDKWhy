package com.example.learningbeggining.repository;


import com.example.learningbeggining.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Аннотация @Repository указывает, что данный интерфейс является репозиторием, который
// позволяет взаимодействовать с базой данных. Например, проводить CRUD операции.
@Repository
public interface ArticleRepository extends JpaRepository<Articles, Long> {

    // Метод для получения списка статей по ID пользователя.
    // Он выполняет запрос к базе данных и возвращает все статьи, принадлежащие конкретному пользователю.
    List<Articles> findByUserId(Long userId);

    // Метод для получения первой статьи пользователя с самым высоким номером статьи.
    // Он возвращает опциональное значение, так как может вернуться пустым, если статья не найдена.
    Optional<Articles> findFirstByUserIdOrderByArticleNumberDesc(Long userId);
}
