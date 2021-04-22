package com.pose.pojo.plan;

import com.pose.pojo.Correction;
import com.pose.pojo.Reward;

import java.util.List;

public class Plan extends BasePlan<Correction>{
    public Plan() {
    }

    public Plan(String reportId, int totalDuration, int currentDuration, Reward reward, List<Correction> corrections) {
        super(reportId, totalDuration, currentDuration, reward, corrections);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "reportId='" + reportId + '\'' +
                ", totalDuration=" + totalDuration +
                ", currentDuration=" + currentDuration +
                ", reward=" + reward +
                ", corrections=" + corrections +
                '}';
    }
}
