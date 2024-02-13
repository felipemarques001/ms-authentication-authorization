package com.felipe.msauthenticationauthorization.exceptions;

public class JwtTokenCreationException extends RuntimeException {

    public JwtTokenCreationException() {
        super("There was an error at the JWT token creation!");
    }
}
