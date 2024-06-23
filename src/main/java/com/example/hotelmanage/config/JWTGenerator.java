package com.example.hotelmanage.config;

import com.example.hotelmanage.guest.GuestController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTGenerator {
    private final Logger log = LoggerFactory.getLogger(GuestController.class);



public String generateToken(Authentication authentication){
    String email = authentication.getName();
    Date curentDate=new Date();
    Date expiryDate=new Date(curentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

    String token = Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS256, SecurityConstants.JWT_SECRET)
            .compact();

    log.info("token generated");

    return token;

}

public String getEmailFromJWT(String token){
    Claims claims=Jwts
            .parser()
            .setSigningKey(SecurityConstants.JWT_SECRET)
            .build().parseSignedClaims(token).getPayload();
    log.info("email got from token:"+ claims.getSubject());

    return claims.getSubject();
}


public boolean validateToken(String token) {
    try {
        Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).build().parseSignedClaims(token);
        log.info("token validated");
        return true;
    }catch (Exception ex){
     throw new AuthenticationCredentialsNotFoundException("JWT WAS EXPIRED OR INCORRECT");
    }
}


}
