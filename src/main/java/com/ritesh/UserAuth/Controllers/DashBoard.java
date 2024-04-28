package com.ritesh.UserAuth.Controllers;

import com.ritesh.UserAuth.DBUtils.Validate_Name;
import com.ritesh.UserAuth.Entity.User;
import com.ritesh.UserAuth.GMailControls.GMailEntity;
import com.ritesh.UserAuth.Hashing.GenerateHashCode;
import com.ritesh.UserAuth.Regex_Validation.Gmail_Validation;
import com.ritesh.UserAuth.Regex_Validation.Password_Validation;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
                            HttpSession session)
    {
        user.setName(Name);
        user.setEmail_Id(EMail);
        validateName.isNameAvailable();

        gmailValidation.validate_gmail(EMail);
        passwordValidation.validate(Password);

        gMailEntity.setTo(EMail);
        generateHashCode.Hash_Id(Password);
        return "Dashboard";
    }
}
