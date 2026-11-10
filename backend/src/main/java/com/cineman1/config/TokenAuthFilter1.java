package com.cineman1.config;

import com.cineman1.service.TokenService1;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filter kiem tra token cho cac endpoint /api/statistics/**.
 * Token gui qua header "Authorization: Bearer <token>" hoac header "X-Auth-Token".
 */
@Component
public class TokenAuthFilter1 extends OncePerRequestFilter {

    private final TokenService1 tokenService1;

    public TokenAuthFilter1(TokenService1 tokenService1) {
        this.tokenService1 = tokenService1;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getRequestURI().startsWith("/api/statistics");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = null;
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            token = authorization.substring("Bearer ".length()).trim();
        }
        if (token == null || token.isEmpty()) {
            token = request.getHeader("X-Auth-Token");
        }
        if (!tokenService1.tokenHopLe(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"message\":\"Chưa đăng nhập hoặc phiên đăng nhập đã hết hạn\"}");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
