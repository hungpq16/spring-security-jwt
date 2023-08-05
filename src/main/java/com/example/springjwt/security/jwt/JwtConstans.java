package com.example.springjwt.security.jwt;

public class JwtConstans {
    public static final String JWT_SECRET = "hungpq";
    public static final long JWT_EXPIRATION_TIME = 86400000000L; // 10 days
    public static final String JWT_TOKEN_PREFIX = "Bearer ";
    public static final String JWT_HEADER_AUTHORIZATION = "Authorization";
}
