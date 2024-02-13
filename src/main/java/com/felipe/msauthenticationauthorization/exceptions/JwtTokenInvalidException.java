package com.felipe.msauthenticationauthorization.exceptions;

public class JwtTokenInvalidException extends RuntimeException {

    public JwtTokenInvalidException() {
        super("The JWT token is invalid!");
    }
}
