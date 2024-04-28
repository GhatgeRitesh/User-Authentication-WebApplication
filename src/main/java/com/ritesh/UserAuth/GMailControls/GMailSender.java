package com.ritesh.UserAuth.GMailControls;

import com.ritesh.UserAuth.Entity.User;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;
@Component
public class GMailSender {

    @Autowired
    private final GMailEntity gMailEntity;

    public GMailSender( GMailEntity gMailEntity) {
        this.gMailEntity = gMailEntity;
    }

    public Boolean SendEmail(){

        //logic

        //SMTP Server details
        Properties prop=new Properties();
        prop.put("mail.smtp.auth",true);
        prop.put("mail.smtp.starttls.enable",true);
        prop.put("mail.smtp.port","587");
        prop.put("mail.smtp.host","smtp.gmail.com");

        String username="riteshghatge5555";
        String password="yxwa yzwq gkfr nery";

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
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(gMailEntity.getTo()));
            msg.setFrom(new InternetAddress(from));
            msg.setSubject(gMailEntity.getSubject());
            msg.setContent(gMailEntity.getText(),"text/html");
            Transport.send(msg);
            System.out.println("Gmail Sent Successfully");
            return true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}
