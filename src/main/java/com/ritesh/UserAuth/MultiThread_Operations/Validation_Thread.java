//package com.ritesh.UserAuth.MultiThread_Operations;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//public class Validation_Thread {
//    public static void main(String[] args) {
//        String Name="";
//        String email_ID="";
//        String Password="";
//
//        ExecutorService executor = Executors.newFixedThreadPool(3); // Create a thread pool with 3 threads
//
//        // Flags to indicate errors
//        AtomicBoolean nameError = new AtomicBoolean(false);
//        AtomicBoolean emailError = new AtomicBoolean(false);
//        AtomicBoolean passwordError = new AtomicBoolean(false);
//
//        executor.submit(() -> {
//            if (!Name.validate_Name(name)) {
//                nameError.set(true);
//            }
//        });
//
//        executor.submit(() -> {
//            if (!Gregex.validate_gmail(email_ID)) {
//                emailError.set(true);
//            }
//        });
//
//        String finalPassword = Password;
//        executor.submit(() -> {
//            if (!regex.validate(finalPassword)) {
//                passwordError.set(true);
//            }
//        });
//
//        executor.shutdown(); // Shut down the executor service
//        try {
//            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for all tasks to complete
//
//            // Redirect based on error flags
//            if (nameError.get()) {
//                log.warning("Error in Name");
//                String error3 = "3";
//                session.setAttribute("NameError", error3);
//                return "redirect:/register";
//            }
//            if (emailError.get()) {
//                log.warning("Error in Gmail");
//                String error2 = "2";
//                session.setAttribute("GmailError", error2);
//                return "redirect:/register";
//            }
//            if (passwordError.get()) {
//                log.warning("Error in password");
//                String error1 = "1";
//                session.setAttribute("PassError", error1);
//                return "redirect:/register";
//            }
//        } catch (InterruptedException e) {
//            // Handle interruption
//        }
//
//    }
//}
