package com.ritesh.UserAuth.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class RegisterController {
    @GetMapping("register")
    public String register(){
        return "register";
    }
    @PostMapping("submit_register")
    public String register(@RequestParam("Name") String Name,
                           @RequestParam("Email_Id")String Email_ID,
                           @RequestParam("password") String password,
                           HttpSession session
    ){
        //----------------------------------------for password verification -------------------------------------------
        if(password.length()!=7)
        {
            String error="1";
            session.setAttribute("Error",error);
            return "redirect:/register";
        }

        //---------- ----------------------------for Email Validation ------------------------------------------------
        char[] chararray =Email_ID.toCharArray();
        ArrayList<Character> EChar=new ArrayList<>();
        // using for each loop allocating the string to the list of cahracters of email address
        for(char a: chararray )
        {
            EChar.add(a);
        }

//-------------------------------------------------------------------------------------------------------------------
        //if all constrainst satisfies
        return "Login";
    }
}
