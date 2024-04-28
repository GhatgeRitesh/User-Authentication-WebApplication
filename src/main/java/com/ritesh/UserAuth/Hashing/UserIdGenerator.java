package com.ritesh.UserAuth.Hashing;

import com.ritesh.UserAuth.Entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log
public class UserIdGenerator {
    //code to generate user id
    @Autowired
    private final User user;
    public UserIdGenerator(User user) {
        this.user = user;
    }
    public void generateUserId() {
        if(user==null)
        {
            log.warning("The User Entity is Empty :");
        }
        String C = user.getName() + user.getEmail_Id();

        // creating hashcode
        int hash = Objects.hash(C);
        String key = String.format("%06d", Math.abs(hash) % 100000);
        user.setId(Long.parseLong(key));
    }
}
