package com.felipe.msauthenticationauthorization.exceptions;

public class GroupNotBelongApplicationException extends RuntimeException {

    public GroupNotBelongApplicationException() {
        super("The specified group does not belong to the application");
    }
}
