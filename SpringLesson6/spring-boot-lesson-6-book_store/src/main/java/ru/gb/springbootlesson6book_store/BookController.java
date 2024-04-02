package ru.gb.springbootlesson6book_store;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Optional<Book> book = bookService.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable Long id){
        book.setId(id);
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}