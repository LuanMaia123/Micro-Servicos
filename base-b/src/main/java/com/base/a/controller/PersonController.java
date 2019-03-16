package com.base.a.controller;

import com.base.a.model.Person;
import com.base.a.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> people = personRepository.findAll();
        return new ResponseEntity<List<Person>>(people, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Person> read(@PathVariable long id) {
        Person person = personRepository.findOne(id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }


}
