package com.pose.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Report {
    private String id;
    private String userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;
    private Body body;
    private List<Problem> problems;

    public Report() {
    }

    public Report(String id, String userId, Date date, Body body, List<Problem> problems) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.body = body;
        this.problems = problems;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", date=" + date +
                ", body=" + body +
                ", problems=" + problems +
                '}';
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }
}
