package ru.gb.springLesson4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryDB extends JpaRepository<User, Long> {

}
