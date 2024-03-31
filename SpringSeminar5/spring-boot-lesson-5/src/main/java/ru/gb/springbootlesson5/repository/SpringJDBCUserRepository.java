package ru.gb.springbootlesson5.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.springbootlesson5.entity.User;

public interface SpringJDBCUserRepository extends CrudRepository<User, Long> {
}
