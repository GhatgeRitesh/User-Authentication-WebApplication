package com.ritesh.UserAuth.GMailAPI;

import com.ritesh.UserAuth.Model.User;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;
@Component
public class GMailSender {
    @Autowired
    private final User user;

    public GMailSender(User user) {
        this.user = user;
    }

    public Boolean SendEmail(){
        boolean flag=false;

        //logic

        //SMTP Server details
        Properties prop=new Properties();
        prop.put("mail.smtp.auth",true);
        prop.put("mail.smtp.starttls.enable",true);
        prop.put("mail.smtp.port","587");
        prop.put("mail.smtp.host","smtp.gmail.com");

        String username="riteshghatge5555";
        String password="jajk kkow cucf vadk";

        String from="riteshghatge5555@gmail.com";

        //session coding
        Session session=Session.getInstance(prop,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });

        //MimeMessage Code to develop matter of the Email
        try{
            Message msg=new MimeMessage(session);
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(user.getTo()));
            msg.setFrom(new InternetAddress(from));
            msg.setSubject(user.getSubject());
            msg.setText(user.getText());
            Transport.send(msg);
            flag=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }


        return flag;
    }
}
