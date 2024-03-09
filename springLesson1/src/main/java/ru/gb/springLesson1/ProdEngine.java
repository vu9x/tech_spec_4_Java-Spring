package ru.gb.springLesson1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdEngine implements Engine{
    public ProdEngine(){
        System.out.println("Engine has been started on server!");
    }

    public void go(){
        System.out.println("Go fast.");
    }
}
