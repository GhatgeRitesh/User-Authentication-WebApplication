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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


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
    private final GenerateHashCode hash;
    @Autowired
    private final UserIdGenerator userIdGenerator;
    @Autowired
    private NewUserFileSystem newUserFileSystem;
    public RegisterController(AddNewUser addNewUser, Password_Validation regex, Gmail_Validation Gregex, Validate_Name Name, User user, GenerateHashCode hash, UserIdGenerator userIdGenerator) {
        this.addNewUser = addNewUser;
        this.regex = regex;
        this.Gregex = Gregex;
        this.Name = Name;
        this.user = user;
        this.hash = hash;
        this.userIdGenerator = userIdGenerator;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/submit_register")
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
            return "register";
        }

        //---------------------------------------for Email Validation ------------------------------------------------

        if(!Gregex.validate_gmail(email_ID))
        {
            log.warning("Error in Gmail");
            session.addAttribute("Error","2");
            return "register";
        }

        //----------------------------------------for password verification -------------------------------------------
        if(!regex.validate(Password))
        {
            log.warning("Error in password");
            session.addAttribute("Error","3");
            return "register";
        }

        //create userid
        userIdGenerator.generateUserId();
        hash.Hash_Id(Password);

       if(!addNewUser.save()){
           log.warning("error in server while utilizing jdbctemplate");
           session.addAttribute("Error","4");
          return "register";
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
        return "Welcome";
    }

}
