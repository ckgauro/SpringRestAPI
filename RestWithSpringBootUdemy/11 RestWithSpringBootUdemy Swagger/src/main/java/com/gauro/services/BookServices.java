package com.gauro.services;

import com.gauro.converter.DozerConverter;
import com.gauro.data.model.Book;
import com.gauro.data.vo.v1.BookVO;
import com.gauro.exception.ResourceNotFoundException;
import com.gauro.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<BookVO> findAll() {
        return  DozerConverter.parseListObjects(bookRepository.findAll(),BookVO.class);

    }

    public BookVO findById(Long id){
        var entity=bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity,BookVO.class);
    }
    public BookVO update(BookVO book) {
        var entity = bookRepository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
        return vo;
    }

    public void delete(Long id) {
        Book entity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        bookRepository.delete(entity);
    }








}
