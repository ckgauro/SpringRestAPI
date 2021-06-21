package com.gauro.repository;

import com.gauro.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chandra
 */
//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
