package ru.gb.springbootseminar8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootSeminar8Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootSeminar8Application.class, args);

		ApplicationContext context = SpringApplication.run(SpringBootSeminar8Application.class, args);

//		MyServiceBean bean = context.getBean(MyServiceBean.class);
//		System.out.println((new MyServiceBean()).getClass().getName());
//		System.out.println(bean.getClass().getName());
//		bean.method1("test");
////		bean.method2("test2");
////		bean.method3("test3");

		Volvo volvo = context.getBean(Volvo.class);
		volvo.method1("test");
		volvo.method2();
		volvo.method3();


	}

}
