package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.RetriveUserData;
import com.ritesh.UserAuth.DBUtils.Verify_User;
import com.ritesh.UserAuth.Hashing.GenerateHashCode;
import com.ritesh.UserAuth.Regex_Validation.Gmail_Validation;
import com.ritesh.UserAuth.Regex_Validation.Password_Validation;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ritesh.UserAuth.Entity.User;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("UserAuth")
@Log
public class LoginController {
    @Autowired
    private final Password_Validation regex;
    @Autowired
    private final Gmail_Validation gmailValidation;
    @Autowired
    private final Verify_User verifyUser;
    @Autowired
    private final User user;
    @Autowired
    private final GenerateHashCode hash;
    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private final RetriveUserData retriveUserData;

    public LoginController(Password_Validation regex, Gmail_Validation gmailValidation, Verify_User verifyUser, User user, GenerateHashCode hash, RestTemplate restTemplate, RetriveUserData retriveUserData) {
        this.regex = regex;
        this.gmailValidation = gmailValidation;
        this.verifyUser = verifyUser;
        this.user = user;
        this.hash = hash;
        this.restTemplate = restTemplate;
        this.retriveUserData = retriveUserData;
    }

    // this is the Login Page Controller used to handel the Login transactions
    @GetMapping("/Login")
    public ModelAndView login(ModelAndView mv) {
        mv.setViewName("Login");
        return mv;
    }
    @PostMapping("/u/Login/submit")
    public String login_Check(@RequestParam("Email_id")String email_ID,
                              @RequestParam("password")String Password,
                              Model session
                              ){

 //-------------------------------function for the valid password length ---------------------------------------------
   if(!regex.validate(Password)){
       log.info("Password length invalid");
       session.addAttribute("Error","1");
       ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:8081/Login",String.class);
       return response.getBody();
   }
   if(!gmailValidation.validate_gmail(email_ID))
   {
     log.info("Invalid Email Syntax");
     session.addAttribute("Error","0");
       ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:8081/Login",String.class);
       return response.getBody();
   }
// ------------------------------function for the password check ----------------------------------------------------
        hash.Hash_Id(Password);
        user.setEmail_Id(email_ID);

        if(!verifyUser.verifyUser()){
            String baseUrl="http://localhost:8081/UserAuth/Login";
            log.info("User Not Found");
            session.addAttribute("Error","2");
             ResponseEntity<String> response=restTemplate.getForEntity(baseUrl,String.class);
             return response.getBody();
        }
        retriveUserData.getData();
//----------------------------------------------------------------------------------------------------------------------
        String baseUrl = "http://localhost:8081/";
        String welcomeEndpoint = "/UserAuth/u/"+user.getId()+"/Welcome";

        String apiUrl = baseUrl + welcomeEndpoint;
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        return response.getBody();
    }
}