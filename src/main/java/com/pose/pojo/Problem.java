package com.pose.pojo;

public class Problem {
    private String reportId;
    private String name;
    private String description;
    private float angle;
    private int extent;
    private String image;
    private String content;

    public Problem() {
    }

    public Problem(String reportId, String name, String description, float angle, int extent, String image, String content) {
        this.reportId = reportId;
        this.name = name;
        this.description = description;
        this.angle = angle;
        this.extent = extent;
        this.image = image;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExtent() {
        return extent;
    }

    public void setExtent(int extent) {
        this.extent = extent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "reportId='" + reportId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", angle=" + angle +
                ", extent=" + extent +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
