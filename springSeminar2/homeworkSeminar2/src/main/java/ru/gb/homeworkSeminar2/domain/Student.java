package ru.gb.homeworkSeminar2.domain;

import lombok.Data;

@Data
public class Student {
    private static long curId = 0;
    private final long id;
    private final String name;
    private final String groupName;

    public Student(String name, String groupName){
        this.name = name;
        this.groupName = groupName;
        this.id = curId++;
    }
}
