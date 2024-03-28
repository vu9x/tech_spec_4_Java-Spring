package ru.gb.springbootseminar3.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private static long genId;

    private final long id;
    private final long idReader;
    private final long idBook;
    private LocalDateTime issuedTime;
    private LocalDateTime returnedTime = null;

    public Issue(long idReader, long idBook){
        id = genId++;
        this.idBook = idBook;
        this.idReader = idReader;
        this.issuedTime = LocalDateTime.now();
    }

}
