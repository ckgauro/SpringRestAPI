package com.gauro.repository;

import com.gauro.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chandra
 */
//@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
