package bmi.Service;

import bmi.Entity.*;
import bmi.Interface.ClassificationInterface;

import java.util.TreeMap;

public class Calculate {

    public double calculateBmi(double weight, double height) {
        return (weight / (Math.pow(height, 2)));
    }

    public double round(double value) {
        return (Math.round(value * 1000.0) / 1000.0);
    }

    public String classifyTest(double bmi) {
        return test(bmi).getClassification();
    }

    private ClassificationInterface test(double bmi) {
        TreeMap<Double, ClassificationInterface> map = new TreeMap<>();
        map.put(0.0, new Underweight());
        map.put(20.0, new NormalWeight());
        map.put(25.0, new Overweight());
        map.put(30.0, new SevereObesity());
        map.put(35.0, new ExtremeObesity());

        return map.floorEntry(bmi).getValue();
    }

    public double getIdealWeightForHeight(double height, double bmi) {
        return Math.pow(height, 2) * test(bmi).perfectBmi();
    }

    public double getWeightDifference(double height, double bmi, double weight) {
        return getIdealWeightForHeight(height, bmi) - weight;
    }

    public boolean hasPerfectBmi(double bmi) {
        return bmi == 22.5;
    }
}
