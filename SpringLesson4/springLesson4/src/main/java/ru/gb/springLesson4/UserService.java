package ru.gb.springLesson4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositoryDB userRepositoryDB;


    public List<User> getAllUsers(){
        userRepositoryDB.save(new User(null, "Evgeny", "abc@gmail.com"));
        userRepositoryDB.save(new User(null, "Mike", "mike@gmail.com"));
        userRepositoryDB.save(new User(null, "John", "john@gmail.com"));
        return userRepositoryDB.findAll();
    }

    public User getUserById(Long id){
        return userRepositoryDB.findById(id).get();
    }
}
