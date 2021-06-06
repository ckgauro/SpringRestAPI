package com.gauro.controller;

import com.gauro.data.vo.PersonVO;
import com.gauro.services.PersonServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Chandra
 */
@Slf4j
@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping
    public List<PersonVO> findAll(){
        return personServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public PersonVO findById(@PathVariable("id") Long id){
        return personServices.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person){
        return personServices.create(person);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO person){
        log.info("Update is called =====>");
        log.info(person.toString());
        return  personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        personServices.delete(id);
        return ResponseEntity.ok().build();

    }


}
