package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.JDBC;
import com.ritesh.UserAuth.Hashing.GetHash_ID;
import com.ritesh.UserAuth.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Controller
public class deletecontroller {
    @Autowired
    private final GetHash_ID hash;
    @Autowired
    private final User user;
    @Autowired
    private final JDBC b;

    public deletecontroller(GetHash_ID hash, User user, JDBC b) {
        this.hash = hash;
        this.user = user;
        this.b = b;
    }

    @GetMapping("/delete")
    public String home(){
        return "delete";
    }

    @PostMapping("/delete1")
    public String deleteAccount(@RequestParam String pass, HttpSession session){

        //----------------code for the validation of the password -------------------------------------
        String hashcode=hash.Hash_Id(pass);
        user.setPassword(hashcode);
        boolean flag=b.verify();
        if(flag)
        {
            boolean flag2=b.delete();
            if(flag2){System.out.println("Deleted Successfully");}
            else{
                System.out.println("deletion error");
            }
        }
        else{
            String error="1";
            session.setAttribute("error",error);
            return "redirect:/delete";
        }
        return "UserAuth";
    }
}
