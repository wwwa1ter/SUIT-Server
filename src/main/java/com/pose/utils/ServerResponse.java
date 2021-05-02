package com.pose.utils;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {
    private String msg;
    private T data;

    public ServerResponse() {
    }

    public ServerResponse(T data) {
        this.data = data;
    }

    public ServerResponse(String msg) {
        this.msg = msg;
    }

    public ServerResponse(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
