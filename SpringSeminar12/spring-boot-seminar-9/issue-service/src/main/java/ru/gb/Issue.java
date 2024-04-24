package ru.gb;

import lombok.Data;
import ru.gb.dto.AuthorDTO;
import ru.gb.dto.BookDTO;
import ru.gb.dto.ReaderDTO;

import java.util.UUID;

@Data
public class Issue {

    private UUID id;
    private BookDTO book;
    private ReaderDTO reader;
    private AuthorDTO author;
}
