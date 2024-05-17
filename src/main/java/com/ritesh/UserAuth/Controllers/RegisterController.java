package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.AddNewUser;
import com.ritesh.UserAuth.DBUtils.Validate_Name;
import com.ritesh.UserAuth.Hashing.GenerateHashCode;
import com.ritesh.UserAuth.Entity.User;
import com.ritesh.UserAuth.Hashing.UserIdGenerator;
import com.ritesh.UserAuth.Regex_Validation.Gmail_Validation;
import com.ritesh.UserAuth.Regex_Validation.Password_Validation;
import com.ritesh.UserAuth.Upload.NewUserFileSystem;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;


@RestController
@RequestMapping("UserAuth")
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
    private final GenerateHashCode hash;
    @Autowired
    private final UserIdGenerator userIdGenerator;
    @Autowired
    private NewUserFileSystem newUserFileSystem;
    @Autowired
    private final RestTemplate restTemplate;

    public RegisterController(AddNewUser addNewUser, Password_Validation regex, Gmail_Validation Gregex, Validate_Name Name, User user, GenerateHashCode hash, UserIdGenerator userIdGenerator, RestTemplate restTemplate) {
        this.addNewUser = addNewUser;
        this.regex = regex;
        this.Gregex = Gregex;
        this.Name = Name;
        this.user = user;
        this.hash = hash;
        this.userIdGenerator = userIdGenerator;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView mv){
        mv.setViewName("register");
        return mv;
    }
    @PostMapping("/Register/NewUser")
    public String register(@RequestParam("Name") String name,
                           @RequestParam("EmailId")String email_ID,
                           @RequestParam("password") String Password,
                           Model session,HttpSession session1, HttpServletRequest request
                           ){
        //testing the parameters are updated or not
         user.setEmail_Id(email_ID);
         user.setName(name);

//        ----------------------------------------for handling the same username ---------------------------------------
        if(!Name.isNameAvailable())
        {
            log.info(" Name is not available");
            session.addAttribute("Error","1");
            String BaseUrl="http://localhost:8081";
            String UserUrl="/UserAuth/"+"register";
            ResponseEntity<String> response=restTemplate.getForEntity(BaseUrl+UserUrl,String.class, HttpStatus.OK);
            return response.getBody();
        }

        //---------------------------------------for Email Validation ------------------------------------------------

        if(!Gregex.validate_gmail(email_ID))
        {
            log.warning("Error in Gmail");
            session.addAttribute("Error","2");
            String BaseUrl="http://localhost:8081";
            String UserUrl="/UserAuth/"+"register";
            ResponseEntity<String> response=restTemplate.getForEntity(BaseUrl+UserUrl,String.class, HttpStatus.OK);
            return response.getBody();
        }

        //----------------------------------------for password verification -------------------------------------------
        if(!regex.validate(Password))
        {
            log.warning("Error in password");
            session.addAttribute("Error","3");
            String BaseUrl="http://localhost:8081";
            String UserUrl="/UserAuth/"+"register";
            ResponseEntity<String> response=restTemplate.getForEntity(BaseUrl+UserUrl,String.class, HttpStatus.OK);
            return response.getBody();
        }

        //create userid
        userIdGenerator.generateUserId();
        hash.Hash_Id(Password);

       if(!addNewUser.save()){
           log.warning("error in server while utilizing jdbctemplate");
           session.addAttribute("Error","4");
           String BaseUrl="http://localhost:8081";
           String UserUrl="/UserAuth/"+"register";
           ResponseEntity<String> response=restTemplate.getForEntity(BaseUrl+UserUrl,String.class, HttpStatus.OK);
           return response.getBody();
       }
       try {
           log.info("creating folder");
           newUserFileSystem.createFolder();
       }catch(Exception e){
           log.info("folder error :"+e);
       }

       //Retrieve HttpSession or create a new one if not exists
             session1 = request.getSession();

            // Get or generate session ID
            String sessionId = (String) session1.getAttribute("sessionId");
            if (sessionId == null) {
                sessionId = UUID.randomUUID().toString();
                session1.setAttribute("sessionId", sessionId);
            }
            System.out.println(sessionId);
            log.info("Session id" + sessionId);
//-------------------------------------------------------------------------------------------------------------------
        //if all constrainst satisfied
        String BaseUrl="http://localhost:8081";
        String UserUrl="/UserAuth/u/"+user.getId()+"/Welcome";
        ResponseEntity<String> response=restTemplate.getForEntity(BaseUrl+UserUrl,String.class, HttpStatus.OK);
        return response.getBody();
    }

}
