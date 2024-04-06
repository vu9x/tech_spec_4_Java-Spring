package ru.gb;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("issue")
@RequiredArgsConstructor
public class IssueController {

    private List<Issue> list;
    private final BookProvider provider;

    @PostConstruct
    public void generateIssue(){
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());
            issue.setReader(provider.getRanDomReader());
            issue.setBook(provider.getRandomBook());
            issue.setAuthor(provider.getRandomBook().getAuthor());

            list.add(issue);
        }
    }

    @GetMapping("refresh")
    public List<Issue> refresh(){
        generateIssue();
        return list;
    }

    @GetMapping()
    public List<Issue> getAll(){
        return list;
    }
}
