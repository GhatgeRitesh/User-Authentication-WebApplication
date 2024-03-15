package com.ritesh.UserAuth.Controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Controller
public class welcomecontroller {
    @GetMapping("/Welcome")
    public String welcomecontroller(){
        return "Welcome";
    }
}
