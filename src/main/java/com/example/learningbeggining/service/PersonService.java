package com.example.learningbeggining.service;


import com.example.learningbeggining.model.Person;
import com.example.learningbeggining.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public Optional<Person> findByUserId(String userId) {
        return personRepository.findByUserId(userId);
    }
}
