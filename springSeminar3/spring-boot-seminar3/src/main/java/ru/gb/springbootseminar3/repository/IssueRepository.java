package ru.gb.springbootseminar3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springbootseminar3.entity.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IssueRepository {
    private List<Issue> list = new ArrayList<>();

    public Issue createIssue(Issue issue){
        list.add(issue);
        return issue;
    }

    public Issue findById(long id){
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Issue> findByReaderId(long id){
        return list.stream()
                .filter(e -> e.getIdReader() == id)
                .collect(Collectors.toList());
    }
}
