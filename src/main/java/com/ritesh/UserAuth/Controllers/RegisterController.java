package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.AddNewUser;
import com.ritesh.UserAuth.DBUtils.Validate_Name;
import com.ritesh.UserAuth.Hashing.GetHash_ID;
import com.ritesh.UserAuth.Model.User;
import com.ritesh.UserAuth.Regex_Validation.Gmail_Validation;
import com.ritesh.UserAuth.Regex_Validation.Password_Validation;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Component
@Log
public class RegisterController{
    @Autowired
    private final AddNewUser addNewUser;
    @Autowired
    private final Password_Validation regex;
    @Autowired
    private final Gmail_Validation Gregex;
    @Autowired
    private final Validate_Name Name;
    @Autowired
    private final User user;
    @Autowired
    private final GetHash_ID hash;
    public RegisterController(AddNewUser addNewUser, Password_Validation regex, Gmail_Validation Gregex, Validate_Name Name, User user, GetHash_ID hash) {
        this.addNewUser = addNewUser;
        this.regex = regex;
        this.Gregex = Gregex;
        this.Name = Name;
        this.user = user;
        this.hash = hash;
    }

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
         user.setEmail_Id(email_ID);
         user.setName(name);

//        ----------------------------------------for handling the same username ---------------------------------------
        if(!Name.isNameAvailable())
        {
            log.info(" Name is not available");
            String error3="3";
            session.setAttribute("NameError",error3);
            return "redirect:/register";
        }

        //---------- ----------------------------for Email Validation ------------------------------------------------

        if(!Gregex.validate_gmail(email_ID))
        {
            log.warning("Error in Gmail");
            String error2="2";
            session.setAttribute("GmailError",error2);
            return "redirect:/register";
        }

        //----------------------------------------for password verification -------------------------------------------
        if(!regex.validate(Password))
        {
            log.warning("Error in password");
            String error1="1";
            session.setAttribute("PassError",error1);
            return "redirect:/register";
        }
        //------------------------------------For the Hash Id ------------------------------------------------------------------
        Password= hash.Hash_Id(Password);
        user.setPassword(Password);


       if(!addNewUser.save()){
           log.warning("error in server while utilizing jdbctemplate");
           String error4="4";
           session.setAttribute("ServerError",error4);
          return "redirect:/register";
       }

//-------------------------------------------------------------------------------------------------------------------
        //if all constrainst satisfied
        return "redirect:/Login";
    }

}
