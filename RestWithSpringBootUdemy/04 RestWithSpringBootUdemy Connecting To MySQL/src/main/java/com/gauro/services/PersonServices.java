package com.gauro.services;

import com.gauro.exception.ResourceNotFoundException;
import com.gauro.model.Person;
import com.gauro.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * @author Chandra
 */
@Service
public class PersonServices {

    public static final String NO_RECORDS_FOUND_FOR_THIS_ID = "No records found for this ID";
    private final PersonRepository personRepository;

    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {

        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
    }

    public Person update(Person person) {
        Person entityPerson = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));

        entityPerson.setFirstName(person.getFirstName());
        entityPerson.setLastName(person.getLastName());
        entityPerson.setAddress(person.getAddress());
        entityPerson.setGender(person.getGender());

        return personRepository.save(entityPerson);

        // return  personRepository.save();
    }

    public void delete(Long id) {

        Person person=personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        personRepository.delete(person);

    }


}
