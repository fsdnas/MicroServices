package com.mobileapp.exceptions;

public class MobileNotFoundException extends RuntimeException {
    public MobileNotFoundException() {
    }

    public MobileNotFoundException(String message) {
        super(message);
    }
}
