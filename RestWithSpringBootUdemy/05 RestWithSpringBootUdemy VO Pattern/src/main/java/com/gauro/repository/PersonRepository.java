package com.gauro.repository;

import com.gauro.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chandra
 */
//@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
