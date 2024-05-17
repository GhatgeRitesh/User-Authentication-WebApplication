package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.ResetPassword;
import com.ritesh.UserAuth.Entity.User;
import com.ritesh.UserAuth.Hashing.GenerateHashCode;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log
public class PassReset {

    @Autowired
    private final User user;
    @Autowired
    private final ResetPassword resetp;
    @Autowired
    private final GenerateHashCode generateHashCode;


    public  PassReset(User user, ResetPassword resetp, GenerateHashCode generateHashCode)
    {
        this.user=user;
        this.resetp = resetp;
        this.generateHashCode = generateHashCode;
    }

    @GetMapping
            ("/ResetPassword")
    public String passResetController(Model m)
    {
        log.info("Controller activated ");
        if(user==null)
        {
            log.info("User Entity is Null");
            m.addAttribute("Error","1");
            return "ResetPassword";
        }
        m.addAttribute("Name",user.getName());
        m.addAttribute("UserId",user.getId());
        log.info(" Resetting password");
        return "ResetPassword";
    }

    @PostMapping("/resetpassword")
    public String resetPassword(@RequestParam("newPassword") String newp,@RequestParam("Recheck") String check , Model m)
    {
        log.info("From activated");
        if(!newp.equals(check))
        {
            log.info("Both password do not match ");
            return "ResetPassword";
        }
        user.setPassword(newp);
        generateHashCode.Hash_Id(newp);
       if(!resetp.setpassword())
       {
          log.info("fail to reset password");
          return "Login";
       }

        return "Welcome";
    }
}
