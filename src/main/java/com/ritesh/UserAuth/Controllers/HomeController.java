package com.ritesh.UserAuth.Controllers;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    //     @GetMapping(value="/home")
    @GetMapping("/UserAuth")
    public String index() {
        System.out.println("home method started to run succesfully");
        return "index";
    }
}

