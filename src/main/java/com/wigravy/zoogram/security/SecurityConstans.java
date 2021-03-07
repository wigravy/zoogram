package com.wigravy.zoogram.security;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstans {
    public static final String SIGH_UP_URL = "/api/v1/auth/**";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000;
}