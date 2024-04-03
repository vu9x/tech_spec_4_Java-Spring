package ru.gb.myshopbookv2.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.RefreshEventListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.myshopbookv2.model.Person;
import ru.gb.myshopbookv2.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person createPerson(Person person){
        return personRepository.save(person);
    }
    public Person findByLogin(String login){
        return personRepository.findByLogin(login).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Нет пользователя с login " + login));
    }

    @EventListener(ContextRefreshedEvent.class)
    private void createStartData(){
        System.out.println("test");

        Person person1 = new Person();
        person1.setLogin("admin");
        person1.setPassword("admin");
        person1.setRole("adminRole");

        Person person2 = new Person();
        person2.setLogin("user");
        person2.setPassword("user");
        person2.setRole("userRole");

        createPerson(person1);
        createPerson(person2);
    }
}
