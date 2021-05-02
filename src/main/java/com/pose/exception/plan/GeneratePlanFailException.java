package com.pose.exception.plan;

public class GeneratePlanFailException extends RuntimeException{
    public GeneratePlanFailException() {
    }

    public GeneratePlanFailException(String message) {
        super(message);
    }
}
