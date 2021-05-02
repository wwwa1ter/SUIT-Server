package com.pose.exception.user;

public class RegisterFailException extends RuntimeException{
    public RegisterFailException() {
    }

    public RegisterFailException(String message) {
        super(message);
    }
}
