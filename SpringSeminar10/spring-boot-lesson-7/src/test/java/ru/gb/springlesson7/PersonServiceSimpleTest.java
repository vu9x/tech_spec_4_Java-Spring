package ru.gb.springlesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.gb.springlesson7.model.Person;
import ru.gb.springlesson7.repository.PersonRepository;
import ru.gb.springlesson7.service.PersonService;


import java.util.Optional;

import static org.mockito.Mockito.verify;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PersonServiceSimpleTest {
//    @Mock
//    PersonRepository personRepository;

//    @InjectMocks

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void createStartDataTest(){

        // pre
        Person person1 = new Person();
        person1.setLogin("admin");
        person1.setPassword("admin");
        person1.setRole("admin");

        Person person2 = new Person();
        person2.setLogin("user");
        person2.setPassword("user");
        person2.setRole("user");


        // action
        personService.createPerson(person1);
        personService.createPerson(person2);


        //check
        Assertions.assertEquals(personService.findById(person1.getId()), person1);
        Assertions.assertEquals(personService.findById(person2.getId()), person2);
    }
}
