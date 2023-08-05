package com.example.springjwt.security.jwt;

import com.example.springjwt.security.userprinciple.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    /**
     * Create access token after login success
     *
     * @param authentication
     * @return
     */
    public String createToken(Authentication authentication) {
        // Get info of current username after login
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrinciple.getUsername()) // set subject for current username
                .setIssuedAt(new Date()) // set at current time
                .setExpiration(new Date(new Date().getTime() + JwtConstans.JWT_EXPIRATION_TIME)) // set time will Expiration
                .signWith(SignatureAlgorithm.HS512, JwtConstans.JWT_SECRET) // register with key and secret
                .compact();
    }

    /**
     * Validate access token is correct?
     *
     * @param token
     * @return
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JwtConstans.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {}", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid format Token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty --> Message {}", e);
        }
        return false;
    }

    /**
     * Get userName by access token
     *
     * @param token
     * @return
     */
    public String getUerNameFromToken(String token) {
        String userName = Jwts.parser()
                        .setSigningKey(JwtConstans.JWT_SECRET)
                        .parseClaimsJws(token).getBody().getSubject();
        return userName;
    }

}