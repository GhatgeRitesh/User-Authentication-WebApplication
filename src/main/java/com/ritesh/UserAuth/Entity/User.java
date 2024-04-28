package com.ritesh.UserAuth.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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

    //--------------------------- to have access to the gmail hash id-------------------------------------------------------
    private long Hashcode;
    public long getHashcode() {
        return Hashcode;
    }

    public void setHashcode(long hashcode) {
        Hashcode = hashcode;
    }

   @Getter @Setter
    private Long Id;

    @Getter @Setter
    private String FileName;

    @Getter @Setter
    private MultipartFile File;
}