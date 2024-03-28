package ru.gb.springbootseminar3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootseminar3.entity.Book;
import ru.gb.springbootseminar3.entity.Issue;
import ru.gb.springbootseminar3.entity.Reader;
import ru.gb.springbootseminar3.repository.ReaderRepository;
import ru.gb.springbootseminar3.requests.BookRequest;
import ru.gb.springbootseminar3.requests.ReaderRequest;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository){
        this.readerRepository = readerRepository;
    }

    public Reader createReader(ReaderRequest readerRequest){
        if(readerRequest.getName() == null){
            log.info("Пользователь не создана. Не введено имя");
            throw new NoSuchElementException("Вы не ввели имя пользователя " + readerRequest.getName());
        }
        return readerRepository.createReader(readerRequest.getName());
    }

    public Reader findReaderById(long id){
        log.info("Поступил запрос на поиск пользоваеля с id=" + id);

        if(readerRepository.findById(id) == null){
            throw new NoSuchElementException("Пользователя с id=" +  id + " не существует");
        }

        return readerRepository.findById(id);
    }

    public boolean deleteReaderById(long id){
        log.info("Поступил запрос на удаление пользователя с id=" + id);

        return readerRepository.deleteReaderById(id);
    }

    public List<Reader> getAllReaders(){
        List<Reader> allReaders = readerRepository.getList();

        if(allReaders.isEmpty()){
            String message = "В библиотеке нет читателей";
            log.info(message);
            throw new NoSuchElementException(message);
        }
        return allReaders;
    }
}
