package com.pose.pojo;

public class Guidance {
    private String movementName;
    private int sequence;
    private String image;
    private String note;

    public Guidance() {
    }

    public Guidance(String movementName, int sequence, String image, String note) {
        this.movementName = movementName;
        this.sequence = sequence;
        this.image = image;
        this.note = note;
    }

    public String getMovementName() {
        return movementName;
    }

    public void setMovementName(String movementName) {
        this.movementName = movementName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Guidance{" +
                "movementName='" + movementName + '\'' +
                ", sequence=" + sequence +
                ", image='" + image + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
