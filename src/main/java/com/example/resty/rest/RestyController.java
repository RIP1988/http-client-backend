package com.example.resty.rest;

import com.example.resty.book.dos.BookDO;
import com.example.resty.book.entity.BookBE;
import com.example.resty.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestyController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity getBooks() {

        System.out.println("GET called");
        List<BookBE> books = bookService.findAll();
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(books);

    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseEntity getBook(@RequestParam Long id) {

        BookBE book = bookService.findById(id);
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(book);
    }

    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    public ResponseEntity saveBook(@RequestBody BookBE book) {
        bookService.saveBook(book);
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*").body(null);
    }

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public ResponseEntity initDB() {
        if (bookService.findAll().isEmpty()) {
            BookBE book1 = new BookBE("Hobbit", "J.R.R. Tolkien");
            BookBE book2 = new BookBE("Lord of the rings", "J.R.R. Tolkien");
            BookBE book3 = new BookBE("Harry Potter", "J.K. Rowling");
            BookBE book4 = new BookBE("Name of the wind", "Patrick Rothfuss");
            BookBE book5 = new BookBE("Crime and punishment", "F. Dostoyewski");
            List<BookBE> books = Arrays.asList(book1, book2, book3, book4, book5);
            books.forEach(book -> {
                bookService.saveBook(book);
            });
        }
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*").body(null);
    }

}
