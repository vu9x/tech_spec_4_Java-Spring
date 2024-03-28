package ru.gb.springbootseminar3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springbootseminar3.entity.Book;
import ru.gb.springbootseminar3.entity.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> list = new ArrayList<>();

    public BookRepository(){
        list.add(new Book("Война и мир"));
        list.add(new Book("Мастер и Маргарита"));
        list.add(new Book("Приключение Буратино"));
    }

    public List<Book> getList() {
        return list;
    }

    public Book findById(long id){
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Boolean deleteBookById(long id){
        return list.removeIf(book -> book.getId() == id);
    }

    public Book createBook(String name){
        Book createdBook = new Book(name);
        list.add(createdBook);
        return createdBook;
    }
}
