package ru.gb.springbootseminar3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springbootseminar3.entity.Reader;

public interface JpaReaderRepository extends JpaRepository<Reader, Long> {
}
