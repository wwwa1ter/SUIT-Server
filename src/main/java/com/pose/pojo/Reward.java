package com.pose.pojo;

public class Reward {
    private String reportId;
    private String rewardName;
    private String rewardDescription;
    private int icon;
    private int rewardState;

    public Reward() {
    }

    public Reward(String reportId, String rewardName, String rewardDescription, int icon, int rewardState) {
        this.reportId = reportId;
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.icon = icon;
        this.rewardState = rewardState;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "reportId='" + reportId + '\'' +
                ", rewardName='" + rewardName + '\'' +
                ", rewardDescription='" + rewardDescription + '\'' +
                ", icon=" + icon +
                ", rewardState=" + rewardState +
                '}';
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getRewardState() {
        return rewardState;
    }

    public void setRewardState(int rewardState) {
        this.rewardState = rewardState;
    }
}
