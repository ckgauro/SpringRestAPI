package com.gauro.controller;

import com.gauro.model.Person;
import com.gauro.services.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Chandra
 */
@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping
    public List<Person> findAll(){
        return personServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") Long id){
        return personServices.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personServices.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return  personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        personServices.delete(id);
        return ResponseEntity.ok().build();

    }


}
