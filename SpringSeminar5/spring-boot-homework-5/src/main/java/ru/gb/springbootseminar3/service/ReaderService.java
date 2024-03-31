package ru.gb.springbootseminar3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootseminar3.entity.Reader;
import ru.gb.springbootseminar3.repository.JpaReaderRepository;
import ru.gb.springbootseminar3.requests.ReaderRequest;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class ReaderService {
    private final JpaReaderRepository readerRepository;

    @Autowired
    public ReaderService(JpaReaderRepository readerRepository){
        this.readerRepository = readerRepository;
    }

    public Reader createReader(ReaderRequest readerRequest){
        Reader newReader = new Reader(readerRequest.getName());
        if(readerRequest.getName() == null){
            log.info("Пользователь не создана. Не введено имя");
            throw new NoSuchElementException("Вы не ввели имя пользователя " + readerRequest.getName());
        }
        return readerRepository.save(newReader);
    }

    public Reader findReaderById(long id){
        log.info("Поступил запрос на поиск пользоваеля с id=" + id);

        if(readerRepository.findById(id) == null){
            throw new NoSuchElementException("Пользователя с id=" +  id + " не существует");
        }

        return readerRepository.findById(id).orElseThrow();
    }

    public boolean deleteReaderById(long id){

        log.info("Поступил запрос на удаление пользователя с id=" + id);
        try{
            readerRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public List<Reader> getAllReaders(){
        List<Reader> allReaders = readerRepository.findAll();

        if(allReaders.isEmpty()){
            String message = "В библиотеке нет читателей";
            log.info(message);
            throw new NoSuchElementException(message);
        }
        return allReaders;
    }
}
