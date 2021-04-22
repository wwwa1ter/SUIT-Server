package com.pose.pojo.plan;

import com.pose.pojo.Correction;
import com.pose.pojo.Reward;

import java.util.List;

public class BasePlan <T>{
    protected String reportId;
    protected int totalDuration;
    protected int currentDuration;
    protected Reward reward;
    protected List<T> corrections;

    public BasePlan() {
    }

    public BasePlan(String reportId, int totalDuration, int currentDuration, Reward reward, List<T> corrections) {
        this.reportId = reportId;
        this.totalDuration = totalDuration;
        this.currentDuration = currentDuration;
        this.reward = reward;
        this.corrections = corrections;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getCurrentDuration() {
        return currentDuration;
    }

    public void setCurrentDuration(int currentDuration) {
        this.currentDuration = currentDuration;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public List<T> getCorrections() {
        return corrections;
    }

    public void setCorrections(List<T> corrections) {
        this.corrections = corrections;
    }

    @Override
    public String toString() {
        return "BasePlan{" +
                "reportId='" + reportId + '\'' +
                ", totalDuration=" + totalDuration +
                ", currentDuration=" + currentDuration +
                ", reward=" + reward +
                ", corrections=" + corrections +
                '}';
    }
}
