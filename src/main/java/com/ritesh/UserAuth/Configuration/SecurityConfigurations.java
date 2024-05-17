//package com.ritesh.UserAuth.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigurations {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
//    {
//     return httpSecurity.authorizeHttpRequests(registry ->{
//         registry.requestMatchers("/public/")
//                 .permitAll();
//         registry.requestMatchers("/**").authenticated();
//         registry.anyRequest().authenticated();
//     }).formLogin(httpSecurityFormLoginConfigurer -> {
//         httpSecurityFormLoginConfigurer.loginPage("/Login").permitAll();
//     }).build();
//    }
//}
