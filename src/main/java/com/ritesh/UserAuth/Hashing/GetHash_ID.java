package com.ritesh.UserAuth.Hashing;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class GetHash_ID {
    public String Hash_Id(String password){
        String inputString = "Hello, world!";
        StringBuilder hexString = new StringBuilder();
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply the hash function to the input string
            byte[] hashBytes = digest.digest(inputString.getBytes());

            // Convert byte array to hexadecimal format

            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Print the hash value
            System.out.println("SHA-256 Hash: " + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return hexString.toString();
    }
}

