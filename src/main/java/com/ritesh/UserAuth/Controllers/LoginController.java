package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.RetriveUserData;
import com.ritesh.UserAuth.DBUtils.Verify_User;
import com.ritesh.UserAuth.GMailControls.GMailSender;
import com.ritesh.UserAuth.Hashing.GenerateHashCode;
import com.ritesh.UserAuth.Regex_Validation.Password_Validation;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ritesh.UserAuth.Entity.User;
@Controller
@Service
@Log
public class LoginController {
    @Autowired
    private final Password_Validation regex;
    @Autowired
    private final Verify_User verifyUser;
    @Autowired
    private final User user;
    @Autowired
    private final GenerateHashCode hash;

    @Autowired
    private final GMailSender sender;
    @Autowired
    private final RetriveUserData retriveUserData;

    public LoginController(Password_Validation regex, Verify_User verifyUser, User user, GenerateHashCode hash, GMailSender sender, RetriveUserData retriveUserData) {
        this.regex = regex;
        this.verifyUser = verifyUser;
        this.user = user;
        this.hash = hash;
        this.sender = sender;
        this.retriveUserData = retriveUserData;
    }

    // this is the Login Page Controller used to handel the Login transactions
    @GetMapping("Login")
    public String login() {
        return "Login";
    }
    @PostMapping("/submit")
    public String login_Check(@RequestParam("Email_id")String email_ID,
                              @RequestParam("password")String Password,
                              HttpSession session
                              ){

 //-------------------------------function for the valid password length ---------------------------------------------
   if(!regex.validate(Password)){
       log.info("Password length invalid");
       String error="1";
       session.setAttribute("PassError",error);
       return "redirect:/Login";
   }
// ------------------------------function for the password check ----------------------------------------------------
        hash.Hash_Id(Password);
        user.setEmail_Id(email_ID);

        if(!verifyUser.verifyUser()){
            log.info("User Not Found");
            String error="2";
            session.setAttribute("Invalid_Credentials",error);
            return "redirect:/Login";
        }
        retriveUserData.getData();
//----------------------------------------------------------------------------------------------------------------------
        return "Welcome";
    }
}
