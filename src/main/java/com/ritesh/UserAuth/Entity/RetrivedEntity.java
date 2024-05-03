package com.ritesh.UserAuth.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RetrivedEntity {
    //code to set entity for retrived user data
    // from user
    @Getter @Setter
    private String Name;
    @Getter @Setter
    private String Email;
    @Getter @Setter
    private String Password;
    @Getter @Setter
    private String Id;
  // formatted code will be used on  advancement

}
