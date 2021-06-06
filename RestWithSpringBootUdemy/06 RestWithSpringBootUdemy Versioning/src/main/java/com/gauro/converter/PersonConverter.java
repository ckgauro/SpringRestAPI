package com.gauro.converter;

import com.gauro.data.model.Person;
import com.gauro.data.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Chandra
 */
@Service
public class PersonConverter {
    public PersonVOV2 convertEntityToVO(Person person) {
        return PersonVOV2.builder()
                .id(person.getId())
                .address(person.getAddress())
                .birthDay(new Date())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .gender(person.getGender())
                .build();
    }
    public Person convertVOToEntity(PersonVOV2 person) {
        return Person.builder()
                .id(person.getId())
                .address(person.getAddress())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .gender(person.getGender())
                .build();
    }
}
