package com.gauro.services;

import com.gauro.converter.DozerConverter;
import com.gauro.data.model.Person;
import com.gauro.data.vo.v1.PersonVO;
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

    public PersonVO create(PersonVO personVO){
        var entity= DozerConverter.parseObject(personVO, Person.class);
        var vo=DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll(){
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        var entity=personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        return DozerConverter.parseObject(entity,PersonVO.class);
    }

    public PersonVO update(PersonVO personVO){
        var entity=personRepository.findById(personVO.getId()).orElseThrow(()->new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setGender(personVO.getGender());
        entity.setAddress(personVO.getAddress());
        var vo=DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return  vo;

    }

    public void delete(Long id){
        Person entity=personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(NO_RECORDS_FOUND_FOR_THIS_ID));
        personRepository.delete(entity);
    }



}