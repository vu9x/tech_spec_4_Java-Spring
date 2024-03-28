package ru.gb.springbootseminar3.repository;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;
import ru.gb.springbootseminar3.entity.Issue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IssueRepository {
    private List<Issue> list = new ArrayList<>();

    public IssueRepository(){
        Issue issue1 = new Issue(1,1);
        issue1.setReturnedTime(LocalDateTime.of(2025,10,20,14,23));
        list.add(issue1);
        list.add(new Issue(0,0));
        list.add(new Issue(0,1));
        list.add(new Issue(0,2));
        list.add(new Issue(2,0));
        list.add(new Issue(2,1));
        list.add(new Issue(2,2));
    }

    public Issue createIssue(Issue issue){
        list.add(issue);
        return issue;
    }

    public Issue returningBook(Issue issue){
        issue.setReturnedTime(LocalDateTime.now());
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

    public List<Issue> getList() {
        return list;
    }
}
