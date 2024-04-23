package ru.gb.springbootseminar3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springbootseminar3.entity.Book;

public interface JpaBookRepository extends JpaRepository<Book, Long> {
}
