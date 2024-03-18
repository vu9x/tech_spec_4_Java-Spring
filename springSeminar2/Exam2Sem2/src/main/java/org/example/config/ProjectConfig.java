package org.example.config;

import org.example.domain.Car;
import org.example.domain.Engin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example.domain")
public class ProjectConfig {

    // Старый способ добавления классов. Редко используют Бины

//    @Bean
//    Engin engin(){
//        Engin eng = new Engin();
//        return eng;
//    }
//
//    @Bean
//    Car car1(){
//        Car obCar = new Car();
//        obCar.setCarEngin(engin());
//        obCar.setModel("X1");
//        obCar.setMade("BMW");
//        return obCar;
//    };
//
//    @Bean
//    @Primary
//    Car car3(){
//        Car obCar = new Car();
//        obCar.setModel("H7");
//        obCar.setMade("HAVAL");
//        return obCar;
//    };

}
