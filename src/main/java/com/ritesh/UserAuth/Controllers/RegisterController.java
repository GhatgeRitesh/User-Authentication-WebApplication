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
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/submit_register")
    public String register(@RequestParam("Name") String name,
                           @RequestParam("EmailId")String email_ID,
                           @RequestParam("password") String Password,
                           HttpSession session
    ){
        //testing the parameters are updated or not
        System.out.println("Name-> "+name+" email --> "+ email_ID+" password --> "+Password);
        System.out.println(Password.length() +" password length");
        //----------------------------------------for password verification -------------------------------------------
        if(Password.length()!=8)
        {
            String error="1";
            session.setAttribute("PassError",error);
            return "redirect:/register";
        }

        //---------- ----------------------------for Email Validation ------------------------------------------------
        char[] chararray =email_ID.toCharArray();
        char[] mail_syntax={'@','g','m','a','i','l','.','c','o','m'};
        // working on the  char array provides efficiency in performance regarding space
        int i=chararray.length-1;
        int j=9;
        int count=0;
        while(count!=10)
        {
            if(chararray[i]==mail_syntax[j])
            {
               i--;
               j--;
            }
            else{
                String error="2";
                session.setAttribute("EmailError",error);
                return "redirect:/register";
            }
            count++;
        }
        // end of the while loop means the email address id is valid
        session.invalidate();

//-------------------------------------------------------------------------------------------------------------------
        //if all constrainst satisfies
        return "/Login";
    }
}
