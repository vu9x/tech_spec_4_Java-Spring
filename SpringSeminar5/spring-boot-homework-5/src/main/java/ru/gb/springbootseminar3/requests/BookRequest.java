package ru.gb.springbootseminar3.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookRequest {


    private String name;
}
