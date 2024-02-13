package com.felipe.msauthenticationauthorization.exceptions;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException() {
        super("The data sent are invalid!");
    }
}
