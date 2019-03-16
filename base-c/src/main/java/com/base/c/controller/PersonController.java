package com.base.c.controller;

import com.base.c.document.Person;
import org.springframework.web.bind.annotation.*;
import com.base.c.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/all")
    public List<Person> getAll(){
        List<Person> people = this.personRepository.findAll();

        return people;
    }
    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") String id){
        Person person = this.personRepository.findById(id);
        return person;
    }


}
