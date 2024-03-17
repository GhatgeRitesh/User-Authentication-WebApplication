package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Controller
public class welcomecontroller {
    @Autowired
    private User user;
    @Autowired
    HttpSession session;
    @GetMapping("/Welcome")
    public String welcomecontroller(){
        session.setAttribute("UserName",user.getName());
        return "Welcome";
    }
}
