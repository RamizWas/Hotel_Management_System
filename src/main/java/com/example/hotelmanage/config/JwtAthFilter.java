package com.example.hotelmanage.config;

import ch.qos.logback.core.util.StringUtil;
import com.example.hotelmanage.guest.GuestController;
import com.example.hotelmanage.guest.GuestRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTGenerator tokenGenerator;
    @Autowired
   private  CustomGuestDetailsService customGuestDetailsService;

    private final Logger log = LoggerFactory.getLogger(GuestController.class);



    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        String token= getJWTFromRequest(request);
        if(StringUtils.hasText(token) && tokenGenerator.validateToken(token)){
            String email=tokenGenerator.getEmailFromJWT(token);
            UserDetails userDetails= customGuestDetailsService.loadUserByUsername(email);
            UsernamePasswordAuthenticationToken authenticationToken
                    =new UsernamePasswordAuthenticationToken
                    (userDetails,
                    userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            log.info("internally filtering");
        }
        filterChain.doFilter(request,response);


    }

    private String getJWTFromRequest(HttpServletRequest httpServletRequest) {

        String bearerToken= httpServletRequest.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            log.info("getting jwt from request");

            return bearerToken.substring(7, bearerToken.length());
        }
        log.info("no jwt in request");

        return null;

    }


}
