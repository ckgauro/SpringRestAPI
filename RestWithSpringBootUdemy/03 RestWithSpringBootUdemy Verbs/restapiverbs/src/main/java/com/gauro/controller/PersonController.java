package com.gauro.controller;

import com.gauro.model.Person;
import com.gauro.services.PersonServices;
import org.springframework.http.MediaType;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return personServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") String id){
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

    @DeleteMapping
    public  void delete(@PathVariable("id") String id){
        personServices.delete(id);
    }


}
