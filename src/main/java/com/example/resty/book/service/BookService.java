package com.example.resty.book.service;

import com.example.resty.book.entity.BookBE;
import com.example.resty.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookBE findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<BookBE> findAll() {
        List<BookBE> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public BookBE saveBook(BookBE book) {
        return bookRepository.save(book);
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
