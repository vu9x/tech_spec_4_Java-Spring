package ru.gb.springbootlesson5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson5.entity.User;
import ru.gb.springbootlesson5.repository.JpaUserRepository;

@Service
@RequiredArgsConstructor
public class JpaUserService {
    private final JpaUserRepository jpaUserRepository;

    public User findByName(String name){
        return jpaUserRepository.findByName(name);
    }
}
