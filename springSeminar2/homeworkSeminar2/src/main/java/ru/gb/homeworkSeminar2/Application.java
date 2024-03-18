package ru.gb.homeworkSeminar2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.homeworkSeminar2.controller.StudentController;
import ru.gb.homeworkSeminar2.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
