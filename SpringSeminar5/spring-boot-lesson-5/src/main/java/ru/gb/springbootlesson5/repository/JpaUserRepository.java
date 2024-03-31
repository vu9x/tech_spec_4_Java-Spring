package ru.gb.springbootlesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springbootlesson5.entity.User;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
