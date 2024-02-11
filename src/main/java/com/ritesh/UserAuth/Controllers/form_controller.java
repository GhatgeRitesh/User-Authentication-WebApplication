package com.ritesh.UserAuth.Controllers;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log
public class form_controller {
      @RequestMapping("/Login")
      public String login(){
          System.out.println("the home method is running");
      return "Login";
      }

      @PostMapping("/submit")
      public String sub(@RequestParam("User_Name")String Name,@RequestParam("password")String password,HttpSession session){
          if(password.length()!=8){
              System.out.println("password error");
              String error="1";
              session.setAttribute("name",error);
              return "redirect:/Login";}

          System.out.println("User Name" +Name);
          System.out.println("Password" +password);
         return "index";
      }

      @GetMapping("/register")
      public String reg(){
          return "register";
      }

    @GetMapping("/forgotpassword")
    public String forgot(){
        return "forgotpassword";
    }
    @PostMapping("/passReset")
    public String reset(@RequestParam("Email_Id")String Name, HttpSession session){
            System.out.println("password error");
            String error="1";
            session.setAttribute("name",error);
            return "redirect:/forgotpassword";
    }
    @PostMapping("/newreg")
    public String reg_sub(@RequestParam("User_Name")String Name,@RequestParam("password")String password,@RequestParam("EmailId") String Email_Id, HttpSession session){
        if(password.length()!=8){
            System.out.println("password error");
            String error="1";
            session.setAttribute("name",error);
            return "redirect:/register";}

        System.out.println("User Name -> " +Name);
        System.out.println("email id -> ");
        System.out.println("Password -> " +password);
        return "Login";
    }
}

