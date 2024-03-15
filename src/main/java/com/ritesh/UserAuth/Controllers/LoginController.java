package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.JDBC;
import com.ritesh.UserAuth.GMailAPI.GMailSender;
import com.ritesh.UserAuth.Hashing.GetHash_ID;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ritesh.UserAuth.Model.User;
@Controller
@Service
@Log
public class LoginController {
    @Autowired
    private JDBC b;
    private final User user;
    @Autowired
    private final GetHash_ID hash;

    public LoginController(User user, GetHash_ID hash) {
        this.user = user;
        this.hash = hash;
    }

    // this is the Login Page Controller used to handel the Login transactions
    @GetMapping("Login")
    public String login() {
        return "Login";
    }
    @PostMapping("submit")
    public String login_Check(@RequestParam("Email_id")String email_ID,
                              @RequestParam("password")String Password,
                              HttpSession session
                              ){

 //-------------------------------function for the valid password length ---------------------------------------------
   if(Password.length()!=8){
       log.info("Password length invalid");
       String error="1";
       session.setAttribute("PassError",error);
       return "redirect:/Login";
   }
// ------------------------------function for the password check ----------------------------------------------------
       Password=hash.Hash_Id(Password);
        user.setEmail_Id(email_ID);
        user.setPassword(Password);
        Boolean flag=b.verify();
        if(!flag){
            log.info("error verification");
            String error="2";
            session.setAttribute("email_invalid",error);
            return "redirect:/Login";
        }

//----------------------------------------------------------------------------------------------------------------------
        return "Welcome";
    }
}
