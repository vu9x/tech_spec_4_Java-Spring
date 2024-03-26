package ru.gb.springbootseminar3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springbootseminar3.entity.Book;
import ru.gb.springbootseminar3.entity.Reader;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReaderRepository {
    private List<Reader> list = new ArrayList<>();

    public ReaderRepository(){
        list.add(new Reader("Костя"));
        list.add(new Reader("Василий"));
        list.add(new Reader("Семен"));
            }

    public Reader findById(long id){
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Boolean deleteReaderById(long id){
        return list.removeIf(reader -> reader.getId() == id);
    }

    public Reader createReader(String name){
        Reader createdBook = new Reader(name);
        list.add(createdBook);
        return createdBook;
    }
}
