package com.ritesh.UserAuth.Controllers;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Log
public class HomeController {
    //     @GetMapping(value="/home")
    @GetMapping("/UserAuth/home")
    public ModelAndView index(ModelAndView mv) {
        log.info("Home page visit");
        mv.setViewName("index");
        return mv;
    }
}