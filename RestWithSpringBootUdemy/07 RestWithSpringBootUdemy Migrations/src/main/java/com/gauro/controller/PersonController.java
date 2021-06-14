package com.gauro.controller;

import com.gauro.data.model.vo.v1.PersonVO;
import com.gauro.services.PersonServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Chandra
 */
@RestController
@RequestMapping("/person/v1")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping
    public List<PersonVO> findAll(){
        return personServices.findAll();
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable("id") long id){
        return personServices.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO personVO){
        return personServices.create(personVO);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO personVO){
        return  personServices.update(personVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        personServices.delete(id);
        return ResponseEntity.ok().build();
    }




}
