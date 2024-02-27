package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.JDBC;
import com.ritesh.UserAuth.Model.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@Component
@Log
public class RegisterController implements CommandLineRunner {
    @Autowired
    private JDBC b;
   private final User user;

    public RegisterController(User user) {
        this.user = user;
    }

    private Boolean flag=false;



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

        // using getter and setters to integrate the data into user class
        System.out.println("setting the name");
        user.setName(name);
        user.setEmail_Id(email_ID);
        user.setPassword(Password);

       b.save();

//-------------------------------------------------------------------------------------------------------------------
        //if all constrainst satisfied
        return "/Login1";

    }


    @Override
    public void run(final String... abc){
        if(flag){
        log.info("Successful userRegistration process complete");}
    }
}
