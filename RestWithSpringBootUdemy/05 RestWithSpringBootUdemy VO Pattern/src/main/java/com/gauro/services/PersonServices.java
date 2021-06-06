package com.gauro.services;

import com.gauro.converter.DozerConverter;
import com.gauro.data.model.Person;
import com.gauro.data.vo.PersonVO;
import com.gauro.exception.ResourceNotFoundException;
import com.gauro.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public PersonVO create(PersonVO person) {
//        var entity= DozerConverter.parseObject(person, Person.class);
//        var vo=DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
//        return vo;
        Person entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll() {
        return  DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);

       // return personRepository.findAll();
    }

    public PersonVO findById(Long id) {

        Person person= personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        return  DozerConverter.parseObject(person, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        Person entityPerson = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));

        entityPerson.setFirstName(person.getFirstName());
        entityPerson.setLastName(person.getLastName());
        entityPerson.setAddress(person.getAddress());
        entityPerson.setGender(person.getGender());
        PersonVO personVO=DozerConverter.parseObject(personRepository.save(entityPerson), PersonVO.class);

        return personVO;

        // return  personRepository.save();
    }

    public void delete(Long id) {

        Person person=personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        personRepository.delete(person);

    }


}
