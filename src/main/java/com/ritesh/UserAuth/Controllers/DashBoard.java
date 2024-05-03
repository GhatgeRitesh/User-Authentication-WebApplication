package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.Validate_Name;
import com.ritesh.UserAuth.DBUtils.Verify_User;
import com.ritesh.UserAuth.Entity.User;
import com.ritesh.UserAuth.GMailControls.GMailEntity;
import com.ritesh.UserAuth.Hashing.GenerateHashCode;
import com.ritesh.UserAuth.Regex_Validation.Gmail_Validation;
import com.ritesh.UserAuth.Regex_Validation.Password_Validation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log
public class DashBoard {
    //code to handle dashboard controls
    @Autowired
    private final User user;
    @Autowired
    private final Validate_Name validateName;
    @Autowired
    private final GenerateHashCode generateHashCode;
    @Autowired
    private final Gmail_Validation gmailValidation;
    @Autowired
    private final Password_Validation passwordValidation;
    @Autowired
    private final GMailEntity gMailEntity;
    @Autowired
    private Verify_User verifyUser;

    public DashBoard(User user, Validate_Name validateName, GenerateHashCode generateHashCode, Gmail_Validation gmailValidation, Password_Validation passwordValidation, GMailEntity gMailEntity) {
        this.user = user;
        this.validateName = validateName;
        this.generateHashCode = generateHashCode;
        this.gmailValidation = gmailValidation;
        this.passwordValidation = passwordValidation;
        this.gMailEntity = gMailEntity;
    }

    @PostMapping("EditInfo")
    public String dashboard(@RequestParam("Name") String Name,
                            @RequestParam("Email")String EMail,
                            @RequestParam("Password")String Password,
                            Model m)
    {

        generateHashCode.Hash_Id(Password);
        // entity assignment
        if(!user.getName().equals(Name) || !user.getEmail_Id().equals(EMail)) {
            user.setName(Name);
            user.setEmail_Id(EMail);

            //syntax validation
            gmailValidation.validate_gmail(EMail);
            passwordValidation.validate(Password);

            //cred validation
            if (!validateName.isNameAvailable()) {
                log.info("Name is not Available");
                m.addAttribute("Name", "1");
                return "redirect:/DashBoard";
            }
            if (!verifyUser.emailValidation(EMail)) {
                log.info("Email is Already in user");
                return "redirect:/DashBoard";
            }
            gMailEntity.setTo(EMail);
            generateHashCode.Hash_Id(Password);
        }
        // setting the new cred

        // validate email if email is changed



        // saving cred into db

        return "Dashboard";
    }

}
/*
0. make sure any of parameter can be changed and remaining may
   be null while all three must not be the null .
1. get parameters and check availability
2. check email reused or not
3. if all checks are done then revalidate the current
   password and Email as per need
4. possible upgrades
   changing user id
   changing file system id -- by now it through error
   for accessing files
5. after creating new cred file system will fail
*/

