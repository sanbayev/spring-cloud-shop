package com.example.userservice.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

public class TokenUtils {

    public static String extractTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // удаляем "Bearer "
        }
        return token;
    }
}
