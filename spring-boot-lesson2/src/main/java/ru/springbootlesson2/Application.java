package ru.springbootlesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

//		UserRepository repository = new UserRepository();
//		System.out.println(repository.getAll());

//		UserRepository userRepository = context.getBean(UserRepository.class);
//		UserRepository userRepository2 = context.getBean(UserRepository.class);
//		System.out.println(userRepository.getById(2));

//		System.out.println(userRepository == userRepository2);
	}

}
