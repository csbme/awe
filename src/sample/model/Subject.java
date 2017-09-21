package sample.model;

import sample.constant.Multiplier;

public class Subject {
    private String label;
    private double multiplier;
    private Grade grade;

    public Subject() {
        this.multiplier = Multiplier.DEFAULT;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
