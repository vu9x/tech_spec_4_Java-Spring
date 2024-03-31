package ru.gb.springbootlesson5.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson5.entity.User;
import ru.gb.springbootlesson5.repository.SpringJDBCUserRepository;

import java.beans.Transient;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SpringJDBCUserRepository springJDBCUserRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onCreateDatabase(){
        springJDBCUserRepository.save(new User("Костя", 15));
        springJDBCUserRepository.save(new User("Василий", 16));
        springJDBCUserRepository.save(new User("Кирилл", 17));
        springJDBCUserRepository.save(new User("Виталий", 18));
    }

    public List<User> getUsers(){
        Iterable<User> iterable = springJDBCUserRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

    //Transactions

    @Transactional
    public void updateUser(long id, String newName, int newAge){
        User user = springJDBCUserRepository.findById(id).orElseThrow();

        user.setName(newName);
        springJDBCUserRepository.save(user);

        fail();

        user.setAge(newAge);
        springJDBCUserRepository.save(user);
    }

    private void fail(){
        throw new RuntimeException("Проблема с записью");
    }
}
