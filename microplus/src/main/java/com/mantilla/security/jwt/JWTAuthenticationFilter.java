package com.mantilla.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author: carlosmantilla
 * @since:
 */
public class JWTAuthenticationFilter extends GenericFilterBean {
    private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationService.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("filter request based in JWT authentication.");
        Authentication authentication = new TokenAuthenticationService().getAuthentication((HttpServletRequest)servletRequest);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
