package com.ritesh.UserAuth.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {
    static {
        System.out.println("Into the user class");
    }
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String email_Id;
    public String getEmail_Id() {
        return email_Id;
    }

    public void setEmail_Id(String email_Id) {
        this.email_Id = email_Id;
    }

    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
      this.Password=Password;
    }



    //------------------------------------------getter and setters for the gmail api --------------------------------------
    private String to;
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    private String subject;
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    private String text;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}