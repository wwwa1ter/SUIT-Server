package com.pose.exception.guidance;

public class GuidanceNotFoundException extends RuntimeException{
    public GuidanceNotFoundException() {
    }

    public GuidanceNotFoundException(String message) {
        super(message);
    }
}
