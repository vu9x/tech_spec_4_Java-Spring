package ru.springbootlesson2;

import lombok.Data;

@Data
public class User {
    private static long curID = 0;
    private final  long id;
    private final String name;

    public User(String name) {
        this.id = curID++;
        this.name = name;
    }

}
