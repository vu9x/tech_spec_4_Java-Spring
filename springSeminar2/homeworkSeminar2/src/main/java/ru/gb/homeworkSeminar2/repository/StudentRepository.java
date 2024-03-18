package ru.gb.homeworkSeminar2.repository;

import org.springframework.stereotype.Component;
import ru.gb.homeworkSeminar2.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private final List<Student> list;

    public StudentRepository(){
        this.list = new ArrayList<>();
        list.add(new Student("Sam", "a"));
        list.add(new Student("Sam", "b"));
        list.add(new Student("John", "c"));
        list.add(new Student("Maria", "a"));
        list.add(new Student("Daria", "b"));
        list.add(new Student("Andrew", "c"));
        list.add(new Student("Ben", "a"));
        list.add(new Student("Sam", "c"));
    }

    public Student getById(long id){
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getByName(String name){
        return list.stream()
                .filter(e -> e.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Student> getAll(){ return List.copyOf(list);}

    public List<Student> getByGroupName(String groupName){
        return list.stream()
                .filter(e -> e.getGroupName().equals(groupName))
                .collect(Collectors.toList());
    }

}
