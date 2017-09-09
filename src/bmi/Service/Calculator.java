package bmi.Service;

import bmi.Constant.ClassificationBmi;
import bmi.Constant.IdealBmi;
import bmi.Entity.*;
import bmi.Entity.Classification.*;
import bmi.Interface.ClassificationInterface;

import java.util.TreeMap;

public class Calculator {
    private static final double ROUND_FACTOR = 100.0;

    private Prepare prepare;

    public double calculateBmi() {
        return round(getWeight() / (Math.pow(getHeight(), 2)));
    }

    public boolean hasIdealBmi() {
        return getBmi() == IdealBmi.NORMAL;
    }

    public double getWeightDifference() {
        return round(getIdealWeightForHeight() - getWeight());
    }

    public double getIdealWeightForHeight() {
        return round(Math.pow(getHeight(), 2) * coolSwitch(getBmi()).perfectBmi());
    }

    public ClassificationInterface getClassificationInterface() {
        return coolSwitch(getBmi());
    }

    private Prepare getPrepare() {
        return prepare;
    }

    public void setPrepare(Prepare prepare) {
        this.prepare = prepare;
    }

    private double getWeight() {
        return getPrepare().getWeight().getValue();
    }

    private double getHeight() {
        return getPrepare().getHeight().getValue();
    }

    private double getBmi() {
        return getPrepare().getBmi().getValue();
    }

    private double round(double value) {
        return (Math.round(value * ROUND_FACTOR) / ROUND_FACTOR);
    }

    private ClassificationInterface coolSwitch(double bmi) {
        TreeMap<Double, ClassificationInterface> map = new TreeMap<>();

        map.put(ClassificationBmi.UNDERWEIGHT, new Underweight());
        map.put(ClassificationBmi.NORMAL, new NormalWeight());
        map.put(ClassificationBmi.OVERWEIGHT, new Overweight());
        map.put(ClassificationBmi.SEVERE_OBESITY, new SevereObesity());
        map.put(ClassificationBmi.EXTREME_OBESITY, new ExtremeObesity());

        return map.floorEntry(bmi).getValue();
    }
}
