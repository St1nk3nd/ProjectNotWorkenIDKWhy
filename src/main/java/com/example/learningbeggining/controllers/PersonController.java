package com.example.learningbeggining.controllers;


import com.example.learningbeggining.model.Person;
import com.example.learningbeggining.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public String listPersons(Model model){
        model.addAttribute("persons", personService.findAll());
        return "person-list";
    }

    @GetMapping("/create")
    public String showCreatePersonForm(Model model){
        model.addAttribute("person", new Person());
        return "create-person";
    }

    @PostMapping("/create")
    public String createPerson(@ModelAttribute Person person, BindingResult result){
        if (result.hasErrors()) {
            return "create-person";
        }
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/{userId}")
    public String showPersonProfile(@PathVariable String userId, Model model) {
        Optional<Person> personOptional = personService.findByUserId(userId);
        if (personOptional.isPresent()) {
            model.addAttribute("person", personOptional.get());
            return "person-profile";
        } else {
            return "error/404"; // Или другая страница, показывающая что пользователь не найден
        }
    }
}
