package com.example.hotelmanage.config;

import com.example.hotelmanage.guest.GuestController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomAcessDeniedHandler implements AccessDeniedHandler {
    private final Logger log = LoggerFactory.getLogger(CustomGuestDetailsService.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("ERROR AUTH USER");
        log.error(accessDeniedException.toString());
        response.setStatus(403);
    }
}
