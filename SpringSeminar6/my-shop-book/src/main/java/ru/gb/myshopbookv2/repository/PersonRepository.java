package ru.gb.myshopbookv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.myshopbookv2.model.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByLogin(String login);
}
