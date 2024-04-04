package ru.gb.springbootseminar8;

import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

@Component
@Loggable(level = Level.WARN)
public class Volvo {

    @Performance
    public void method1(String args){
        System.out.println("Работает метод 1");
    }

//    @Loggable
    @Performance
    public String method2(){
        System.out.println("Работает метод 2");
        return "result";
    }

    public void method3(){
        System.out.println("Работает метод 3");
        throw new RuntimeException("Ошибка в методе 3");
    }
}
