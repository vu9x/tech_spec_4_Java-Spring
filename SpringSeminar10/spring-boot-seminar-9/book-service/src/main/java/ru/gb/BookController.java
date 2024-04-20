package ru.gb;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("book")
public class BookController {
    private final List<Book> books = new ArrayList<>();

    @PostConstruct
    public void generateBookds(){
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setName("Book: " + i);
            book.setAuthor(new Author(UUID.randomUUID(),
                    "first Name: " + random.nextInt(1, 5),
                    "last Name: " + random.nextInt(5, 10)));
            books.add(book);
        }
    }

    @GetMapping()
    public List<Book> getAll(){
        return books;
    }

    @GetMapping("random")
    public Book getById(){
        Random random = new Random();
        return books.get(random.nextInt(books.size()));
//        return books.stream()
//                .filter(book -> book.getId()== id)
//                .findFirst()
//                .orElse(null);
    }


}
