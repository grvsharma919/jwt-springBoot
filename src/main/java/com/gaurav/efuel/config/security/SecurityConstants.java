package com.gaurav.efuel.config.security;

public class SecurityConstants {
    private SecurityConstants() {
    }

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60; // 5 HOURS

    public static final String SIGNING_KEY = "GauravSharma919!";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    public static final String AUTHORITIES_KEY = "scopes";
}
