package com.gauro.controller;

import com.gauro.data.vo.PersonVO;
import com.gauro.data.vo.v2.PersonVOV2;
import com.gauro.services.PersonServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Chandra
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping
    public List<PersonVO> findAll() {
        return personServices.findAll();
    }
    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable("id") Long id) {
        return personServices.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        return personServices.create(person);
    }

    @PostMapping("/v2")
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return personServices.createV2(person);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        return personServices.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personServices.delete(id);
        return ResponseEntity.ok().build();
    }



}
