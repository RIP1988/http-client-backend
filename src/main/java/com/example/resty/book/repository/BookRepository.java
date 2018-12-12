package com.example.resty.book.repository;

import com.example.resty.book.entity.BookBE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookBE, Long> {

}
