package com.example.learningbeggining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.learningbeggining.repository")
@EntityScan(basePackages = "com.example.learningbeggining.model")
public class LearningBeginningApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningBeginningApplication.class, args);
    }
}