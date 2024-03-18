package com.ritesh.UserAuth.Regex_Validation;

import java.util.regex.*;
import org.springframework.stereotype.Component;

@Component
public class Gmail_Validation {
    //code for the valid gmail syntax
    public boolean validate_gmail(String Gmail){

        String pattern="^.*@gamil\\.com$";

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
