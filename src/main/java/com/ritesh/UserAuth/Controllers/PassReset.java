package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.Entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log
public class PassReset {

    @Autowired
    private final User user;

    public  PassReset(User user)
    {
        this.user=user;
    }

    @GetMapping("/ResetPassword")
    public String passResetController(Model m)
    {
        if(user==null)
        {
            log.info("User Entity is Null");
            m.addAttribute("Error","1");
            return "ResetPassword";
        }
        m.addAttribute("Name",user.getName());
        m.addAttribute("UserId",user.getId());
        log.info(" Resetting password");
        return "resetPassword";
    }

    @PostMapping("/resetpassword")
    public String resetPassword(@RequestParam("newPassword") String newp,@RequestParam("Recheck") String check , Model m)
    {
        if(!newp.equals(check))
        {
            log.info("Both password do not match ");
            return "ResetPassword";
        }

        return "Welcome";
    }
}
