package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.RetriveUserData;
import com.ritesh.UserAuth.Entity.User;
import com.ritesh.UserAuth.GMailControls.GMailEntity;
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
    @Autowired
    private final User user;
    @Autowired
    private final GMailEntity gMailEntity;
    @Autowired
    private final RetriveUserData retriveUserData;

    public CodeVerifyController(User user, GMailEntity gMailEntity, RetriveUserData retriveUserData) {
        this.user = user;
        this.gMailEntity = gMailEntity;
        this.retriveUserData = retriveUserData;
    }

    @GetMapping("/CodeVerification")
    public String home(){
        session.setAttribute("Email_Id",user.getEmail_Id());
        return "CodeVerification";
    }
    @PostMapping("/verify")
    public String verifyCode(@RequestParam String code){

        if(code.equals(String.valueOf(gMailEntity.getOTP()))){
            log.info("verified Code");
            retriveUserData.getData();
            return "/ResetPassword";
        }
        log.warning("Incorrect Code!");
        return "/forgotpassword";
    }
}
