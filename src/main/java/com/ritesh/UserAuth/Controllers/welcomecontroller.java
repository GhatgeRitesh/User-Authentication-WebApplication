package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.Entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@RestController
@RequestMapping("UserAuth")
@Log
public class welcomecontroller {
    @Autowired
    private User user;
    @Autowired
    HttpSession session;
    @GetMapping("/u/{id}/Welcome")
    public ModelAndView welcomecontroller(@PathVariable("id") Long id,ModelAndView mv){
        log.info("User Logged in : "+ id);
        mv.addObject("UserName",user.getName());
        mv.setViewName("Welcome");
        return mv;
    }

    @GetMapping("/u/{id}/DashBoard")
    public ModelAndView dash(@PathVariable("id")Long id,ModelAndView mv)
    {
        mv.addObject("Name",user.getName());
        mv.addObject("Email",user.getEmail_Id());
        mv.addObject("UserId",user.getId());
        mv.setViewName("Dashboard");
        return mv;
    }
}
