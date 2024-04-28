package com.ritesh.UserAuth.GMailControls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmailOTPGenerator {
      // code to generate the otp for emails
    @Autowired
    private final GMailEntity gMailEntity;

    public EmailOTPGenerator(GMailEntity gMailEntity) {
        this.gMailEntity = gMailEntity;
    }

    public void getOTP()
      {
          Random random = new Random();
          StringBuilder sb = new StringBuilder();

          // Generate a random 6-digit number
          for (int i = 0; i < 6; i++) {
              int digit = random.nextInt(10); // Generate a digit between 0 and 9
              sb.append(digit);
          }

          long hashcode = Long.parseLong(sb.toString());
          gMailEntity.setOTP(hashcode);
      }
}
