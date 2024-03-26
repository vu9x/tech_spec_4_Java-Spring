//package ru.gb.springbootseminar3.demo;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SecondBean {
//    @Autowired
//    ApplicationEventPublisher publisher;
//
//    @PostConstruct
//    public void postConstruct(){
//        publisher.publishEvent(new MyEvent(this));
//    }
//
//}
