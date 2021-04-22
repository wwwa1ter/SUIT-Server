package com.pose.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EverydayCorrection{
    private String reportId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int state;
    private Correction correction;

    public EverydayCorrection() {
    }

    public EverydayCorrection(String reportId, Date date, int state, Correction correction) {
        this.reportId = reportId;
        this.date = date;
        this.state = state;
        this.correction = correction;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Correction getCorrection() {
        return correction;
    }

    public void setCorrection(Correction correction) {
        this.correction = correction;
    }

    @Override
    public String toString() {
        return "EverydayCorrection{" +
                "reportId='" + reportId + '\'' +
                ", date=" + date +
                ", state=" + state +
                ", correction=" + correction +
                '}';
    }
}
