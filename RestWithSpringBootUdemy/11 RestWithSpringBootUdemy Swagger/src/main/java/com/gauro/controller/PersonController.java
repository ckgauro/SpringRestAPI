package com.gauro.controller;

import com.gauro.data.vo.v1.PersonVO;
import com.gauro.services.PersonServices;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Chandra
 */
@Slf4j

@Api(tags = "Test for Person Controller")
@RestController
@RequestMapping("/persons/v1")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

  //  @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    @GetMapping(produces = {"application/json" , "application/xml"})
    public List<PersonVO> findAll() {
        List<PersonVO> personVOS = personServices.findAll();
        personVOS.stream().forEach(p -> {
            // Link selfLink = linkTo(PersonVO.class).slash("persons/v1/"+  p.getId()).withSelfRel();
            //p.add((selfLink));
            p.add(linkTo(methodOn(PersonController.class).findById(p.getId())).withSelfRel());
        });
        return personVOS;
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO findById(@PathVariable("id") long id) {
        log.info("url======>" + id);
        PersonVO personVO = personServices.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @PostMapping(produces = {"application/json", "application/x-yaml", "application/xml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO create(@RequestBody PersonVO personVO) {
        PersonVO personVO1=personServices.create(personVO);
        personVO1.add(linkTo(methodOn(PersonController.class).findById(personVO1.getId())).withSelfRel());
        return personVO1;
    }

    @PutMapping(produces = {"application/json", "application/json", "application/x-yaml"}, consumes = {"application/x-yaml", "application/json", "application/xml"})
    public PersonVO update(@RequestBody PersonVO personVO) {
        PersonVO personVO1=personServices.update(personVO);
        personVO1.add(linkTo(methodOn(PersonController.class).findById(personVO1.getId())).withSelfRel());


        return personVO1;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        personServices.delete(id);
        return ResponseEntity.ok().build();
    }


}