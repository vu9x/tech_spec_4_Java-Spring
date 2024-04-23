package ru.gb.springbootseminar3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootseminar3.entity.Book;
import ru.gb.springbootseminar3.repository.JpaBookRepository;
import ru.gb.springbootseminar3.requests.BookRequest;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class BookService {
    private final JpaBookRepository bookRepository;

    @Autowired
    public BookService(JpaBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        List<Book> library = bookRepository.findAll();

        if(library.isEmpty()){
            log.info("В библиотеке нет книг");
            throw new NoSuchElementException("В библиотеке нет книг");
        }
        return library;
    }

    public Book createBook(BookRequest bookRequest){
        Book newBook = new Book(bookRequest.getName());
        if(bookRequest.getName() == null){
            log.info("Книга не создана. Не введено имя");
            throw new NoSuchElementException("Вы не ввели имя книги " + bookRequest.getName());
        }
        return bookRepository.save(newBook);
    }

    public Book findBookById(long id){
        log.info("Поступил запрос на поиск книги с id=" + id);

        if(bookRepository.findById(id) == null){
            throw new NoSuchElementException("Книги с id=" +  id + " не существует");
        }

        return bookRepository.findById(id).orElseThrow();
    }

    public boolean deleteBookById(long id){
        log.info("Поступил запрос на удаление книги с id=" + id);

        try{
            bookRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }


}
