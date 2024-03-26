package ru.gb.springbootseminar3.entity;


import lombok.Data;

@Data

public class Book {
    private static long genId;

    private final long id;
    private final String name;

    public Book(String name){
        id = genId++;
        this.name = name;
    }
}
