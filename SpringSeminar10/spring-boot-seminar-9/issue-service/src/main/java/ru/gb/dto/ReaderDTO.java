package ru.gb.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ReaderDTO {
    private UUID id;
    private String name;
}
