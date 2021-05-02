package com.pose.exception.plan;

public class AddFailException extends RuntimeException{
    public AddFailException() {
    }

    public AddFailException(String message) {
        super(message);
    }
}
