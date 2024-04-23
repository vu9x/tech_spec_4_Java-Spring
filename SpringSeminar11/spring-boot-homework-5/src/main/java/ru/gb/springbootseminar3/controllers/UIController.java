package ru.gb.springbootseminar3.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbootseminar3.entity.Book;
import ru.gb.springbootseminar3.entity.Issue;
import ru.gb.springbootseminar3.entity.Reader;
import ru.gb.springbootseminar3.service.IssueService;
import ru.gb.springbootseminar3.service.BookService;
import ru.gb.springbootseminar3.service.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequestMapping("ui")
public class UIController {
    private BookService bookService;
    private ReaderService readerService;
    private IssueService issueService;

    @Autowired
    public UIController(BookService bookService, ReaderService readerService, IssueService issueService){
        this.bookService = bookService;
        this.readerService = readerService;
        this.issueService = issueService;
    }

    //* 1.1 /ui/books - на странице должен отобразиться список всех доступных книг в системе
    @GetMapping("/books")
    public String getAllBooks(Model model){
        log.info("Поступил запрос на отображение списка всех доступных книг в системе.");

        try{
            List<Book> books = bookService.getAllBooks();

            ResponseEntity.status(HttpStatus.OK).body(books);
            model.addAttribute("library", books);
        } catch (NoSuchElementException e){
            log.info(e.getMessage());
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return "ui/books";
    }

    //1.2 /ui/reader - аналогично 1.1
    @GetMapping("/readers")
    public String getAllReaders(Model model){
        log.info("Поступил запрос на отображение всех читателей в системе.");

        try{
            List<Reader> readers = readerService.getAllReaders();

            ResponseEntity.status(HttpStatus.OK).body(readers);
            model.addAttribute("readers", readers);
        } catch (NoSuchElementException e){
            log.info(e.getMessage());
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return "ui/readers";
    }

    // 1.3 /ui/issues - на странице отображается таблица, в которой есть столбцы
    // (книга, читатель, когда взял, когда вернул (если не вернул - пустая ячейка)).
    @GetMapping("/issues")
    public String getAllIssues(Model model){
        log.info("Поступил запрос на отображение всех записей о выдачей в системе.");

        try{
            List<Issue> issues = issueService.getAllIssues();

            ResponseEntity.status(HttpStatus.OK).body(issues);
            model.addAttribute("issues", issues);
        } catch (NoSuchElementException e){
            log.info(e.getMessage());
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return "ui/issues";
    }

    // /ui/reader/{id} - страница, где написано имя читателя с идентификатором id и перечислены книги,
    // которые на руках у этого читателя
    @GetMapping("/reader/{id}")
    public String getReaderIssues(@PathVariable Long id, Model model){
        log.info("Поступил запрос на отображение всех записей читателя с id={}", id);

        try{
            List<Issue> issues = issueService.readerIssues(id);

            ResponseEntity.status(HttpStatus.OK).body(issues);
            model.addAttribute("issues", issues);
        } catch (NoSuchElementException e){
            log.info(e.getMessage());
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return "ui/reader/issues";
    }

}
