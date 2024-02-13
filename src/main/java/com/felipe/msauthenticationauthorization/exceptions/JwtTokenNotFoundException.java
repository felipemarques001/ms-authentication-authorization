package com.felipe.msauthenticationauthorization.exceptions;

public class JwtTokenNotFoundException extends RuntimeException {

    public JwtTokenNotFoundException() {
        super("JWT token not found at request context!");
    }
}
