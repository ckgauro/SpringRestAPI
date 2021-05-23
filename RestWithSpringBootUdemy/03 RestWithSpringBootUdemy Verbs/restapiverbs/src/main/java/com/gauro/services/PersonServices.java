package com.gauro.services;

import com.gauro.model.Person;
import com.github.javafaker.Faker;
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
    Faker faker = new Faker();
    private final AtomicLong counter=new AtomicLong();
    public Person create(Person person){
        return person;
    }

    public  Person update(Person person){
        return  person;
    }
    public  void delete(String id){

    }
    public Person findById(String id){
        return mockPerson();
    }

    public List<Person> findAll(){
        List<Person> personList=new ArrayList<Person>();
        IntStream.rangeClosed(0,10).forEach(el->{
            personList.add(mockPerson());
        });
        return  personList;
    }
    private Person mockPerson() {
        Person person=Person.builder()
                .id(counter.incrementAndGet())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().fullAddress())
                .gender("Male")
                .build();
        return person;
    }


}
