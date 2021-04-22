package com.pose.pojo;

public class Correction {
    protected String id;
    protected String problemName;
    protected Movement movement;
    protected int suitableExtent;
    protected int duration;
    protected int frequency;
    protected int time;
    protected int movementSet;

    public Correction() {
    }

    public Correction(String id, String problemName, Movement movement, int suitableExtent, int duration, int frequency, int time, int movementSet) {
        this.id = id;
        this.problemName = problemName;
        this.movement = movement;
        this.suitableExtent = suitableExtent;
        this.duration = duration;
        this.frequency = frequency;
        this.time = time;
        this.movementSet = movementSet;
    }

    @Override
    public String toString() {
        return "Correction{" +
                "id='" + id + '\'' +
                ", problemName='" + problemName + '\'' +
                ", movement=" + movement +
                ", suitableExtent=" + suitableExtent +
                ", duration=" + duration +
                ", frequency=" + frequency +
                ", time=" + time +
                ", movementSet=" + movementSet +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public int getSuitableExtent() {
        return suitableExtent;
    }

    public void setSuitableExtent(int suitableExtent) {
        this.suitableExtent = suitableExtent;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMovementSet() {
        return movementSet;
    }

    public void setMovementSet(int movementSet) {
        this.movementSet = movementSet;
    }
}
