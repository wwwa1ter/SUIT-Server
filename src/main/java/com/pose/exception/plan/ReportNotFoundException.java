package com.pose.exception.plan;

public class ReportNotFoundException extends RuntimeException{
    public ReportNotFoundException() {
    }

    public ReportNotFoundException(String message) {
        super(message);
    }
}
