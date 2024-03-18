package com.ritesh.UserAuth.Regex_Validation;

import org.springframework.stereotype.Component;

import java.util.regex.*;

@Component
public class Password_Validation {
    // code for the validation of the special 8+ char digit symbol and alphabets password

    public boolean validate(String password){

        String pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+={}\\[\\]:;\"'<>,.?/\\\\])[A-Za-z\\d!@#$%^&*()_+={}\\[\\]:;\"'<>,.?/\\\\]{8,}$";

        Pattern p=Pattern.compile(pattern);
        Matcher matcher1=p.matcher("pass");
        if(!matcher1.matches())
        {
            System.out.println("invalid password pattern");
            return false;
        }
        return true;
    }
}