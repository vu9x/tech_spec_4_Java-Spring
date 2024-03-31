package ru.gb.springbootseminar3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootseminar3.repository.JpaBookRepository;
import ru.gb.springbootseminar3.repository.JpaIssueRepository;
import ru.gb.springbootseminar3.repository.JpaReaderRepository;
import ru.gb.springbootseminar3.requests.IssueRequest;
import ru.gb.springbootseminar3.entity.Issue;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class IssueService {

    private final JpaBookRepository bookRepository;
    private final JpaIssueRepository issueRepository;
    private final JpaReaderRepository readerRepository;

    @Autowired
    public IssueService(JpaBookRepository bookRepository, JpaIssueRepository issueRepository, JpaReaderRepository readerRepository){
        this.bookRepository = bookRepository;
        this.issueRepository = issueRepository;
        this.readerRepository = readerRepository;
    }

    public Issue createIssue(IssueRequest request){
        if(bookRepository.findById(request.getBookId()) == null){
            log.info("Не удалось найти книгу с id " + request.getBookId());
            throw new NoSuchElementException("Не удалось найти книгу с id " + request.getBookId());
        }
        if(readerRepository.findById(request.getReaderId()) == null){
            log.info("Не удалось найти читателя с id " + request.getReaderId());
            throw new NoSuchElementException("Не удалось найти читателя с id " + request.getReaderId());
        }

        Issue issue = new Issue(request.getReaderId(), request.getBookId());
        return issueRepository.save(issue);
    }

    public Issue isReaderGotBook(long readerId, long bookId){
        List<Issue> issuedBooks = issueRepository.findByReaderId(readerId);

        return issuedBooks.stream()
                .filter(element -> element.getBookId() == bookId)
                .findFirst()
                .orElse(null);
    }

    public List<Issue> readerIssues (long readerId){
        return issueRepository.findByReaderId(readerId);

    }

    public Issue findByIssueId(long id){
        if(issueRepository.findById(id) == null){
            log.info("Не удалось найти запись о выдаче {}", id);
            throw new NoSuchElementException("е удалось найти запись о выдаче {}" + id);
        }
        return issueRepository.findById(id).orElseThrow();
    }

    public List<Issue> getAllIssues(){
        List<Issue> allIssues = issueRepository.findAll();

        if(allIssues.isEmpty()){
            String message = "Нет выданных записей";
            log.info(message);
            throw new NoSuchElementException(message);
        }
        return allIssues;
    }

}
