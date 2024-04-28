package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.Verify_User;
import com.ritesh.UserAuth.GMailControls.EmailOTPGenerator;
import com.ritesh.UserAuth.GMailControls.GMailEntity;
import com.ritesh.UserAuth.GMailControls.GMailSender;
import com.ritesh.UserAuth.Entity.User;
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
public class ForgotPassword {
    @Autowired
    private final GMailSender sender;
    @Autowired
    private final User user;
    @Autowired
    private final Verify_User verifyUser;
    @Autowired
    private final GMailEntity gMailEntity;
    @Autowired
    private final EmailOTPGenerator emailOTPGenerator;

    public ForgotPassword(GMailSender sender, User user, Verify_User verifyUser, GMailEntity gMailEntity, EmailOTPGenerator emailOTPGenerator) {
        this.sender = sender;
        this.user = user;
        this.verifyUser = verifyUser;
        this.gMailEntity = gMailEntity;
        this.emailOTPGenerator = emailOTPGenerator;
    }

    @GetMapping("/forgotpassword")
    public String forgot(){
        log.info("into the forgot controller");
        return  "forgotpassword";
    }
    @PostMapping("/Passreset")
    public String Reset(@RequestParam String Email_Id, HttpSession session){

         log.info("working on email verification and entered into the passreset");
        //validating the user exists or not
        boolean flag= verifyUser.emailValidation(Email_Id);
        if(flag){
            user.setEmail_Id(Email_Id);
        }
        else{
            System.out.println("invalid Email");
            String error="1";
            session.setAttribute("error",error);
            return "redirect:/forgotpassword";
        }

//-----------------------Email OTP vefication process started----------------------------------

        emailOTPGenerator.getOTP();
        gMailEntity.setTo(Email_Id);
        if(!sender.SendEmail()){
           log.warning("Email Not Sent ");
           return "redirect:/forgotpassword";
        }
        return "/Code Verification";
    }
}