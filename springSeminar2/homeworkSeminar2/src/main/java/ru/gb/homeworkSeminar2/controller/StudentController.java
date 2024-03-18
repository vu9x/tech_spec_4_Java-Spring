package ru.gb.homeworkSeminar2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.homeworkSeminar2.domain.Student;
import ru.gb.homeworkSeminar2.repository.StudentRepository;

import java.util.List;

@RestController
//@RequestMapping("student")
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) { this.studentRepository = studentRepository;}

    @GetMapping("student/{id}")
    public Student getById(@PathVariable long id){
        return studentRepository.getById(id);
    }

    @GetMapping("student")
    public List<Student> getAll(){
        return studentRepository.getAll();
    }

    @RequestMapping("student/search")
    public List<Student> getByName(@RequestParam String name){
        return studentRepository.getByName(name);
    }
    @RequestMapping("group/{groupName}/student")
    public List<Student> getByGroupName(@PathVariable String groupName){
        return studentRepository.getByGroupName(groupName);
    }
}
