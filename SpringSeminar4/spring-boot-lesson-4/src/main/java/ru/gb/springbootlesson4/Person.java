package ru.gb.springbootlesson4;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String firstName;
    private String middleName;
    private int age;


}
