package com.gauro.services;

import com.gauro.converter.DozerConverter;
import com.gauro.data.model.Book;
import com.gauro.data.vo.v1.BookVO;
import com.gauro.repository.BookRepository;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */

@Service
public class BookServices {

    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookVO create(BookVO bookVO){
        var entity= DozerConverter.parseObject(bookVO, Book.class);
        var vo=DozerConverter.parseObject( bookRepository.save(entity), BookVO.class);
        return vo;
    }






}
