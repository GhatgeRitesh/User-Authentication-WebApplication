package com.ritesh.UserAuth.Configuration;

import com.ritesh.UserAuth.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public User user() {
        User user = new User();
        // Set default values or perform any necessary initialization
        return user;
    }
}
