package com.ritesh.UserAuth.GMailControls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForgotPassword_EMail {
    //code to set email text for email OTP for forgot password
    @Autowired
    private final GMailEntity gMailEntity;

    public ForgotPassword_EMail(GMailEntity gMailEntity) {
        this.gMailEntity = gMailEntity;
    }
    public Boolean sendPasswordRecoveryMail()
    {
        String subject="Your One-Time Password (OTP) for Verification";
        String text="<html><body style=\"font-size:16px;color:black;\">Dear user,<br>\n" +
                "\n" +
                "Thank you for choosing our service. To complete your registration/authentication, please use the following One-Time Password (OTP):<br>\n" +
                "\n" +
                "OTP: <p style=\"font-size:24px\">"+ gMailEntity.getOTP() + "</p><br>\n" +
                "\n" +
                "Please enter this OTP within 2 minutes to verify your account. If you did not request this verification, please ignore this email.<br>\n" +
                "\n" +
                "If you have any questions or concerns, please don't hesitate to contact our support team at <a href=\"www.googlesupport.com\">Contact Support</a><br>\n" +
                "\n" +
                "Best regards,<br>\n" +
                "UserAuth WebServices <br></html></body>";
        gMailEntity.setText(text);
        gMailEntity.setSubject(subject);
        return true;
    }
}
