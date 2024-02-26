package com.ritesh.UserAuth;

import com.ritesh.UserAuth.Model.User;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Log
public class UserAuthApplication implements CommandLineRunner {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(UserAuthApplication.class, args);
	User user = context.getBean(User.class);
	}
	@Override
	public void run(final String...abc){
		log.info("Application Started ");
	}
}
