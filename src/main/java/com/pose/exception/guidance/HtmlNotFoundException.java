package com.pose.exception.guidance;

public class HtmlNotFoundException extends RuntimeException{
    public HtmlNotFoundException() {
    }

    public HtmlNotFoundException(String message) {
        super(message);
    }
}
