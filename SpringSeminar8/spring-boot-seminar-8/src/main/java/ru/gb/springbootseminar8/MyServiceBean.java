package ru.gb.springbootseminar8;

import org.springframework.stereotype.Component;

@Component
public class MyServiceBean {

    // Advice:
    // before
    // afterReturning
    // afterThrowing
    // after
    // around
    public String method1(String arg){
        System.out.println("Работа метода 1");
        method2(arg);
        return "result";
    }

    public String method2(String arg){
        System.out.println("Работа метода 2");
        return "result";
    }

//    public String method3(String arg){
//        System.out.println("Работа метода 3");
//        throw new RuntimeException("Exeption!");
//    }
}
