package com.mk.customer.exception;

public class RegisterNotFoundException extends RuntimeException {

    public RegisterNotFoundException(final String registerClass, final String registerId) {
        super(registerClass + " with id " + registerId + " not found");
    }
}
