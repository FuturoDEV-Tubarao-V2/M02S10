package br.com.futurodev.jwt_sample.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {

    private final JwtAuthenticationProvider JWTAuthenticationProvider;

    public JwtTokenFilter(JwtAuthenticationProvider JWTAuthenticationProvider) {
        this.JWTAuthenticationProvider = JWTAuthenticationProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = this.JWTAuthenticationProvider.resolveToken((HttpServletRequest) servletRequest);
        if (token != null && JWTAuthenticationProvider.validateToken(token)) {
            Authentication authentication = this.JWTAuthenticationProvider.getAuthentication(token);
            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
