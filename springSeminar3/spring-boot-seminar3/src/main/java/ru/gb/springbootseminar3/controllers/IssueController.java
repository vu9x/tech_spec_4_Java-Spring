package ru.gb.springbootseminar3.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootseminar3.entity.Issue;
import ru.gb.springbootseminar3.requests.IssueRequest;
import ru.gb.springbootseminar3.service.IssueService;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("issue")
public class IssueController {

    private IssueService service;

    @Autowired
    public IssueController(IssueService service){
        this.service = service;
    }

    /*
    GET - запрос без тела. Запрос не должен изменять состояние тела
    POST - запрос на создание записи. Есть тело запроса, мы передаем его для создания
    PUT - запрос на обновление\изменение записей
    DELETE - запрос на удаление
     */
    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest issueRequest){
        log.info("Поступли запрос на выдачу: readerId={}, bookId={}",
                issueRequest.getReaderId(),
                issueRequest.getBookId());

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createIssue(issueRequest)) ;
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssue(@PathVariable long id){
        log.info("Поступил запрос на поиск записи о выдаче под номером {}", id);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findByIssueId(id));
        } catch (NoSuchElementException e){
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    //localhost:8080/issue?readerId=1&bookId=0
    public ResponseEntity<Issue> checkUser(@RequestParam long readerId, long bookId){
        log.info("Поступил запрос на проверку книги={} читателя={}", bookId, readerId);
        if(service.isReaderGotBook(readerId, bookId) == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.isReaderGotBook(readerId, bookId));
    }
}
