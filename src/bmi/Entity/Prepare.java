package bmi.Entity;

import bmi.Interface.ClassificationInterface;
import bmi.Interface.ValueInterface;

public class Prepare {
    private ClassificationInterface classificationInterface;
    private ValueInterface weight, height, bmi;

    private double idealWeightForHeight, weightDifference;

    public Prepare(ValueInterface weight, ValueInterface height) {
        this.height = height;
        this.weight = weight;
    }

    public ValueInterface getHeight() {
        return height;
    }

    public ValueInterface getWeight() {
        return weight;
    }

    public ValueInterface getBmi() {
        return bmi;
    }

    public void setBmi(ValueInterface bmi) {
        this.bmi = bmi;
    }

    double getIdealWeightForHeight() {
        return idealWeightForHeight;
    }

    public void setIdealWeightForHeight(double idealWeightForHeight) {
        this.idealWeightForHeight = idealWeightForHeight;
    }

    double getWeightDifference() {
        return weightDifference;
    }

    public void setWeightDifference(double weightDifference) {
        this.weightDifference = weightDifference;
    }

    ClassificationInterface getClassificationInterface() {
        return classificationInterface;
    }

    public void setClassificationInterface(ClassificationInterface classificationInterface) {
        this.classificationInterface = classificationInterface;
    }
}
