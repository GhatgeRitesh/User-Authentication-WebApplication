package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/DashBoard")
    public ModelAndView dash(ModelAndView mv)
    {
        mv.addObject("Name",user.getName());
        mv.addObject("Email",user.getEmail_Id());
        mv.setViewName("Dashboard");
        return mv;
    }
}
