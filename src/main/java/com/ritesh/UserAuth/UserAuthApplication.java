package com.ritesh.UserAuth;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class UserAuthApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthApplication.class, args);
	}
	@Override
	public void run(final String...abc){
		log.info("Application Started ");
	}
}
