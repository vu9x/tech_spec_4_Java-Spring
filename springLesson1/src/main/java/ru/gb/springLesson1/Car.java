package ru.gb.springLesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Car {
//    Engine engine;

//    public Car(Engine engine) {
//        this.engine = engine;
//        engine.go();
//    }
//    public Car(){}
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//        engine.go();
//    }

    @Autowired
    Engine engine;

    public void start(){
        engine.go();
    }
}
