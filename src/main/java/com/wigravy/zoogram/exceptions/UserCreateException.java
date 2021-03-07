package com.wigravy.zoogram.exceptions;

public class UserCreateException extends RuntimeException {
    public UserCreateException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
