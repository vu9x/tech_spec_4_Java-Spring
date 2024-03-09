package ru.gb.springLesson1;

import jakarta.annotation.Priority;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Primary
@Profile("local")
public class LocalEngine implements Engine{
    public LocalEngine(){
        System.out.println("Engine has been started on my PC!");
    }

    public void go(){
        System.out.println("Go slowly.");
    }
}
