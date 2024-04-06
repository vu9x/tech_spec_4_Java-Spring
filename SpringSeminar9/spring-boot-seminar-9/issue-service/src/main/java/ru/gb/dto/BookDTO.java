package ru.gb.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookDTO {
    private UUID id;
    private String name;
    private AuthorDTO author;

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
