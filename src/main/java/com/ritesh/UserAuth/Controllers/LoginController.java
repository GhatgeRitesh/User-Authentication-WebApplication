package com.ritesh.UserAuth.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    // this is the Login Page Controller used to handel the Login transactions
    @GetMapping("Login")
    public String login() {
        return "Login";
    }
    @PostMapping("submit_Login")
    public String login_Check(@RequestParam("User_Name")String user_name,
                              @RequestParam("password")String password,
                              HttpSession session
                              ){
 // ------------------------------function for the password check ----------------------------------------------------

 //-------------------------------function for the valid password length ---------------------------------------------

 //-------------------------------function for password DB authentication --------------------------------------------

//-------------------------------------------if all goes good --------------------------------------------------------
        return "Application";
    }
}
