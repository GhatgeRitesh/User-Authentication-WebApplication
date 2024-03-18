package com.ritesh.UserAuth.Regex_Validation;

import java.util.regex.*;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Log
public class Gmail_Validation {
    //code for the valid gmail syntax
    public boolean validate_gmail(String Gmail){
        log.info("scanning Email");

        String pattern="^.*@gmail\\.com$";

        Pattern p=Pattern.compile(pattern);

        Matcher matcher=p.matcher(Gmail);

        if(!matcher.matches())
        {
            System.out.println("invalid Gmail Pattern");
            return false;
        }
        return true;
    }
}
