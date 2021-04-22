package com.pose.pojo;

public class Body {
    private String reportId;
    private String front;
    private String side;
    private String back;

    public Body() {
    }

    public Body(String reportId, String front, String side, String back) {
        this.reportId = reportId;
        this.front = front;
        this.side = side;
        this.back = back;
    }

    @Override
    public String toString() {
        return "Body{" +
                "reportId='" + reportId + '\'' +
                ", front='" + front + '\'' +
                ", side='" + side + '\'' +
                ", back='" + back + '\'' +
                '}';
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}
