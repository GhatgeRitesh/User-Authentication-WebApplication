package com.ritesh.UserAuth;

import com.ritesh.UserAuth.Model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@SpringBootApplication
@Log
@Service
public class UserAuthApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(UserAuthApplication.class, args);
	}
	@Override
	public void run(final String...abc){
		//System.out.println("the dataSource is --> "+dataSource.toString());

		log.info("Application Started ");
	}
}
