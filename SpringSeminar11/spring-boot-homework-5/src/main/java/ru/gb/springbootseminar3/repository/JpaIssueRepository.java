package ru.gb.springbootseminar3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springbootseminar3.entity.Issue;

import java.util.List;

public interface JpaIssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByReaderId(long id);
}
