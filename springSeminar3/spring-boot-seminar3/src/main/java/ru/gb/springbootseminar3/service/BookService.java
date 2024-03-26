package ru.gb.springbootseminar3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootseminar3.entity.Book;
import ru.gb.springbootseminar3.repository.BookRepository;
import ru.gb.springbootseminar3.requests.BookRequest;

import java.util.NoSuchElementException;

@Slf4j
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(BookRequest bookRequest){
        if(bookRequest.getName() == null){
            log.info("Книга не создана. Не введено имя");
            throw new NoSuchElementException("Вы не ввели имя книги " + bookRequest.getName());
        }
        return bookRepository.createBook(bookRequest.getName());
    }

    public Book findBookById(long id){
        log.info("Поступил запрос на поиск книги с id=" + id);

        if(bookRepository.findById(id) == null){
            throw new NoSuchElementException("Книги с id=" +  id + " не существует");
        }

        return bookRepository.findById(id);
    }

    public boolean deleteBookById(long id){
        log.info("Поступил запрос на удаление книги с id=" + id);

        return bookRepository.deleteBookById(id);
    }


}
