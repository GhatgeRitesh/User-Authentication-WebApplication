package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.Remove_User;
import com.ritesh.UserAuth.Hashing.GenerateHashCode;
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
public class deletecontroller {
    @Autowired
    private final GenerateHashCode hash;
    @Autowired
    private final User user;
    @Autowired
    private final Remove_User removeUser;

    public deletecontroller(GenerateHashCode hash, User user, Remove_User removeUser) {
        this.hash = hash;
        this.user = user;
        this.removeUser = removeUser;
    }

    @GetMapping("/delete")
    public String home(){
        return "delete";
    }

    @PostMapping("/delete1")
    public String deleteAccount(@RequestParam String pass, HttpSession session){

        //----------------code for the validation of the password -------------------------------------
        hash.Hash_Id(pass);
        if(!removeUser.deleteUser()){
            log.info("invalid credential");
            return "redirect:/delete";
        }

        return "UserAuth";
    }
}