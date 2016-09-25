package com.mantilla.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationService.class);
    private TokenAuthenticationService tokenAuthenticationService;

    public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));

        logger.info("Create new JWT Login Filter");
        setAuthenticationManager(authenticationManager);
        tokenAuthenticationService = new TokenAuthenticationService();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        logger.info("Attempt autentication form request " + httpServletRequest);
        AccountCredentials credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(), AccountCredentials.class);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        logger.info("Performance JWT Token createtion if the the authentication was successful.");
        String name = authResult.getName();
        tokenAuthenticationService.addAuthentication(response, name);
    }
}
