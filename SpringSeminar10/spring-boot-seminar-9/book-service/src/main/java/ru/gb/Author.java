package ru.gb;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Author {

    private UUID id;
    private String fistName;
    private String lastName;
}
