package com.ritesh.UserAuth.Configuration;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;

public class SessionCreation {
    public String getSessionId() {
        // Retrieve HttpSession
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();

        // Generate or Retrieve Session ID
        String sessionId = (String) session.getAttribute("sessionId");
        if (sessionId == null) {
            sessionId = UUID.randomUUID().toString(); // Generate a new session ID
            session.setAttribute("sessionId", sessionId); // Store session ID in session
        }

        return "Session ID: " + sessionId;
    }
}
