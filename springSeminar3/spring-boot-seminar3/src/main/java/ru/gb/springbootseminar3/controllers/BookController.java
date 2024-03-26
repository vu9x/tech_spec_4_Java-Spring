package ru.gb.springbootseminar3.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootseminar3.entity.Book;
import ru.gb.springbootseminar3.entity.Issue;
import ru.gb.springbootseminar3.requests.BookRequest;
import ru.gb.springbootseminar3.service.BookService;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest){
        log.info("Поступли запрос на создание книги: {}",
                bookRequest.getName());

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookRequest)) ;
        } catch(NoSuchElementException e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(bookService.findBookById(id)) ;
        } catch(NoSuchElementException e) {
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable long id) {
        if (bookService.deleteBookById(id)) {
            log.info("Книга c id =" + id + " удалена");
            return ResponseEntity.status(HttpStatus.OK).build();

        }
        log.info("Книга c id =" + id + " не найдена");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();

    }

}
