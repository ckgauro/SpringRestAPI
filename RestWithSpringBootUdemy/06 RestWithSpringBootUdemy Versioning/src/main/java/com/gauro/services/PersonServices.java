package com.gauro.services;

import com.gauro.converter.DozerConverter;
import com.gauro.converter.PersonConverter;
import com.gauro.data.model.Person;
import com.gauro.data.vo.PersonVO;
import com.gauro.data.vo.v2.PersonVOV2;
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
    private  final PersonRepository personRepository;
    private final PersonConverter personConverter;

    public PersonServices(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }
    public PersonVO create(PersonVO person) {
        var entity= DozerConverter.parseObject(person, Person.class);
        var vo=DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }
    public PersonVOV2 createV2(PersonVOV2 person) {
        var entity=personConverter.convertVOToEntity(person);
        var vo=personConverter.convertEntityToVO(personRepository.save(entity));
        return vo;
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);

    }
    public PersonVO findById(Long id) {
        var entity=personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        return DozerConverter.parseObject(entity,PersonVO.class);

    }
    public PersonVO update(PersonVO person) {
        var entity=personRepository.findById(person.getId())
                .orElseThrow(()->new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        entity.setFirstName(person.getFirstName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());
        var vo =DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }
    public void delete(Long id) {
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        personRepository.delete(entity);
    }





}
