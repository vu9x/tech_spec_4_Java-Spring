package ru.gb.springbootseminar3.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootseminar3.entity.Issue;
import ru.gb.springbootseminar3.entity.Reader;
import ru.gb.springbootseminar3.requests.ReaderRequest;
import ru.gb.springbootseminar3.service.IssueService;
import ru.gb.springbootseminar3.service.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("reader")
public class ReaderController {

    private ReaderService readerService;
    private IssueService issueService;
    @Autowired
    public ReaderController(ReaderService readerService, IssueService issueService){
        this.readerService = readerService;
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<Reader> createReader(@RequestBody ReaderRequest readerRequest){
        log.info("Поступил запрос на создание читателя: {}",
                readerRequest.getName());

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(readerService.createReader(readerRequest));
        } catch(NoSuchElementException e){
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> findById(@PathVariable long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(readerService.findReaderById(id));
        } catch(NoSuchElementException e){
            log.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reader> deleteById(@PathVariable long id){
        if(readerService.deleteReaderById(id)){
            log.info("Читатель с id=" + id + " удален");
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        log.info("Читатель с id=" + id + " не найден");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @GetMapping("/{id}/issue")
    public ResponseEntity<List<Issue>> readerIssues(@PathVariable long id){
        List<Issue> readerIssues = issueService.readerIssues(id);

        if(readerIssues.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(readerIssues);
    }

}
