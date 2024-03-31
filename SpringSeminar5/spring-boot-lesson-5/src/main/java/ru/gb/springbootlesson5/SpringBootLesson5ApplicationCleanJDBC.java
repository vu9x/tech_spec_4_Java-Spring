package ru.gb.springbootlesson5;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class SpringBootLesson5ApplicationCleanJDBC {

	@SneakyThrows
	public static void main(String[] args) {
//		SpringApplication.run(SpringBootLesson5Application.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootLesson5ApplicationCleanJDBC.class, args);

		DataSource dataSource = context.getBean(DataSource.class);

		try(Connection connection = dataSource.getConnection()){
			try (Statement statement = connection.createStatement()){
				statement.execute("create table if not exists users(id bigint, name varchar(512))");
			}

			try (Statement statement = connection.createStatement()){
				statement.execute("insert into users(id, name) values(1, 'Костя')");
			}

			try (Statement statement = connection.createStatement()){
				ResultSet resultSet = statement.executeQuery("select * from users");
				while(resultSet.next()){
					System.out.println(resultSet.getLong("id"));
					System.out.println(resultSet.getString("name"));
				}
			}
		}
	}

}
