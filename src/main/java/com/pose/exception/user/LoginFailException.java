package com.pose.exception.user;

public class LoginFailException extends RuntimeException{
    public LoginFailException() {
        super();
    }

    public LoginFailException(String message) {
        super(message);
    }
}
