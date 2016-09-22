package com.mantilla.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
public class TokenAuthenticationService {

    private long EXPIRATIONDATE = 1000 * 60 * 60 * 24 * 10; // 10 Days.
    private String secret = "ThisIsASecret";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";

    public void addAuthentication(HttpServletResponse response, String username) {
        // Generate token.
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONDATE))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        response.addHeader(headerString, tokenPrefix + " " + JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerString);
        if (token != null) {
            // Check token
            String username = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            if (username != null) {
                return new AuthenticatedUser(username);
            }
        }

        return null;
    }
}
