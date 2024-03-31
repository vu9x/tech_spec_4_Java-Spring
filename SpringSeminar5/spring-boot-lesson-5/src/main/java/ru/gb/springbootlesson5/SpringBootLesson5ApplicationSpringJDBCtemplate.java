package ru.gb.springbootlesson5;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class SpringBootLesson5ApplicationSpringJDBCtemplate {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootLesson5Application.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootLesson5ApplicationSpringJDBCtemplate.class, args);

//		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//
//		jdbcTemplate.execute("create table if not exists users(id bigint, name varchar(512))");
//		jdbcTemplate.execute("insert into users(id, name) values(1, 'Костя')");

//		List<User> users = jdbcTemplate.query("select * from users", new RowMapper<User>() {
//			@Override
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return new User(rs.getLong("id"), rs.getString("name"));
//			}
//		});
//
//		System.out.println(users);

	}

//	@Data
//	@AllArgsConstructor
//	static class User{
//		private long id;
//		private String name;
//	}
}
