package ru.gb.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthorDTO {

    private UUID id;
    private String fistName;
    private String lastName;
}
