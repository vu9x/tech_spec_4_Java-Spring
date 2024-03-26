package ru.gb.springbootseminar3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootseminar3.requests.IssueRequest;
import ru.gb.springbootseminar3.entity.Issue;
import ru.gb.springbootseminar3.repository.BookRepository;
import ru.gb.springbootseminar3.repository.IssueRepository;
import ru.gb.springbootseminar3.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class IssueService {

    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    @Autowired
    public IssueService(BookRepository bookRepository, IssueRepository issueRepository, ReaderRepository readerRepository){
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
        return issueRepository.createIssue(issue);
    }

    public Issue isReaderGotBook(long readerId, long bookId){
        List<Issue> issuedBooks = issueRepository.findByReaderId(readerId);

        return issuedBooks.stream()
                .filter(element -> element.getIdBook() == bookId)
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
        return issueRepository.findById(id);
    }

}
