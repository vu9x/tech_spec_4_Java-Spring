package ru.springbootlesson2;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
//@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
public class UserRepository {
    private final List<User> list;

    public UserRepository() {
        this.list = new ArrayList<>();
        list.add(new User("Костя"));
        list.add(new User("Иван"));
        list.add(new User("Семен"));
        list.add(new User("Кирилл"));
        list.add(new User("Василий"));
    }

    public User getById(long id){
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User getByName(String name){
        return list.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAll(){
        return List.copyOf(list);
    }
}
