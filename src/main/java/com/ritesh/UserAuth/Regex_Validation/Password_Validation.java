package com.ritesh.UserAuth.Regex_Validation;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.regex.*;

@Component
@Log
public class Password_Validation {
    // code for the validation of the special 8+ char digit symbol and alphabets password

    public boolean validate(String password){
        log.info("Scanning password");

        String pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_={}\\[\\]:;\"'<>,.?/\\\\])[A-Za-z\\d!@#$%^&*()_+={}\\[\\]:;\"'<>,.?/\\\\]{8,}$";

        Pattern p=Pattern.compile(pattern);
        Matcher matcher1=p.matcher(password);
        System.out.println(matcher1.matches());
        if(!matcher1.matches())
        {
            return false;
        }
        return true;
    }
}
