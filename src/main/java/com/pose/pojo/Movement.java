package com.pose.pojo;

public class Movement {
    private String name;
    private String description;
    private String content;

    public Movement() {
    }

    public Movement(String name, String description, String content) {
        this.name = name;
        this.description = description;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
