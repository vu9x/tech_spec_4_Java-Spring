package ru.gb.springbootseminar3.requests;

import lombok.Data;

@Data
public class IssueRequest {
    private long readerId;
    private long bookId;


}
