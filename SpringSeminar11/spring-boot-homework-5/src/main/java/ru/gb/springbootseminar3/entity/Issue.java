package ru.gb.springbootseminar3.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long readerId;
    private long bookId;
    private LocalDateTime issuedTime;

    @Column(nullable = true)
    private LocalDateTime returnedTime;

    public Issue(){}
    public Issue(long readerId, long bookId){
        this.bookId = bookId;
        this.readerId = readerId;
        this.issuedTime = LocalDateTime.now();
    }

}
