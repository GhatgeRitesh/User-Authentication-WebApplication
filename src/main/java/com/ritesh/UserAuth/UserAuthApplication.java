package com.ritesh.UserAuth;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Log
@Service
public class UserAuthApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(UserAuthApplication.class, args);
	}
	@Override
	public void run(final String...abc) {
		//System.out.println("the dataSource is --> "+dataSource.toString());

		log.info("Application Started ");
	}
}
