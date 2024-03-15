package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.Model.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Controller
@Log
public class CodeVerifyController {
    @Autowired
    private HttpSession session;

    @GetMapping("/Code VerifyController")
    public String home(){
        session.setAttribute("Email_Id",user.getEmail_Id());
        return "Code VerifyController";
    }
    @Autowired
    private final User user;

    public  CodeVerifyController(User user){
        this.user=user;
    }

    @PostMapping("/verify")
    public String verifyCode(@RequestParam String code){

        if(code.equals(String.valueOf(user.getHashcode()))){
            log.info("verified Code");
            return "Welcome";
        }
        log.warning("Incorrect Code!");
        return "redirect:/forgotpassword";
    }
}
