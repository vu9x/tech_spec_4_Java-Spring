package ru.gb.springbootseminar8;

import org.springframework.stereotype.Component;

@Component
public final class MyServiceBeanFinal {

    // Advice:
    // before
    // afterReturning
    // afterThrowing
    // after
    // around
    public String method1(String arg){
        System.out.println("Работа метода 1 final class");
        method2(arg);
        return "result";
    }

    public String method2(String arg){
        System.out.println("Работа метода 2 final class");
        return "result";
    }

//    public String method3(String arg){
//        System.out.println("Работа метода 3");
//        throw new RuntimeException("Exeption!");
//    }
}
