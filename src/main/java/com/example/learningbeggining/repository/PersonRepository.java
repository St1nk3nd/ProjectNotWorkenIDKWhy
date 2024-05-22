package com.example.learningbeggining.repository;

import com.example.learningbeggining.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByUserId(String userId);
}
