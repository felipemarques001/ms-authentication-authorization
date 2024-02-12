package com.felipe.msauthenticationauthorization.exceptions;

public class UserNotBelongApplicationException extends RuntimeException {

    public UserNotBelongApplicationException() {
        super("The specified user does not belong to the application");
    }
}
