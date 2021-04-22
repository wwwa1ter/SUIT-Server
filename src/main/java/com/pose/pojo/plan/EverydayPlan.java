package com.pose.pojo.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pose.pojo.Correction;
import com.pose.pojo.EverydayCorrection;
import com.pose.pojo.Reward;

import java.util.Date;
import java.util.List;

public class EverydayPlan extends BasePlan<EverydayCorrection>{

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;

    public EverydayPlan(Date date) {
        this.date = date;
    }

    public EverydayPlan(String reportId, int totalDuration, int currentDuration, Reward reward, List<EverydayCorrection> corrections, Date date) {
        super(reportId, totalDuration, currentDuration, reward, corrections);
        this.date = date;
    }

    public EverydayPlan() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EverydayPlan{" +
                "reportId='" + reportId + '\'' +
                ", totalDuration=" + totalDuration +
                ", currentDuration=" + currentDuration +
                ", reward=" + reward +
                ", corrections=" + corrections +
                ", date=" + date +
                '}';
    }
}
