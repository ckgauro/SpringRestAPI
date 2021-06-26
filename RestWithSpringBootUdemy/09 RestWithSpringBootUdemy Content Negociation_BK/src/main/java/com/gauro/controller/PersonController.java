package com.gauro.controller;

import com.gauro.data.vo.v1.PersonVO;
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
@RequestMapping("/persons/v1")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    //@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    @GetMapping()
    public List<PersonVO> findAll(){
        return personServices.findAll();
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO findById(@PathVariable("id") long id){
        log.info("url======>"+id);
        return personServices.findById(id);
    }

    @PostMapping(produces = {"application/json", "application/x-yaml","application/xml"},
            consumes = {"application/json", "application/xml","application/x-yaml"})
    public PersonVO create(@RequestBody PersonVO personVO){
        return personServices.create(personVO);
    }

    @PutMapping(produces ={"application/json","application/json","application/x-yaml"}, consumes = {"application/x-yaml","application/json","application/xml"})
    public PersonVO update(@RequestBody PersonVO personVO){
        return  personServices.update(personVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        personServices.delete(id);
        return ResponseEntity.ok().build();
    }




}