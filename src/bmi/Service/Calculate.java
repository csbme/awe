package bmi.Service;

import bmi.Constant.ClassificationBmi;
import bmi.Constant.IdealBmi;
import bmi.Entity.*;
import bmi.Interface.ClassificationInterface;

import java.util.TreeMap;

public class Calculate {

    private static final double ROUND_FACTOR = 1000.0;

    public double calculateBmi(double weight, double height) {
        return (weight / (Math.pow(height, 2)));
    }

    public double round(double value) {
        return (Math.round(value * ROUND_FACTOR) / ROUND_FACTOR);
    }

    public String classifyTest(double bmi) {
        return test(bmi).getClassification();
    }

    private ClassificationInterface test(double bmi) {
        TreeMap<Double, ClassificationInterface> map = new TreeMap<>();
        map.put(ClassificationBmi.UNDERWEIGHT, new Underweight());
        map.put(ClassificationBmi.NORMAL, new NormalWeight());
        map.put(ClassificationBmi.OVERWEIGHT, new Overweight());
        map.put(ClassificationBmi.SEVERE_OBESITY, new SevereObesity());
        map.put(ClassificationBmi.EXTREME_OBESITY, new ExtremeObesity());

        return map.floorEntry(bmi).getValue();
    }

    public double getIdealWeightForHeight(double height, double bmi) {
        return round(Math.pow(height, 2) * test(bmi).perfectBmi());
    }

    public double getWeightDifference(double height, double bmi, double weight) {
        return round(getIdealWeightForHeight(height, bmi) - weight);
    }

    public boolean hasIdealBmi(double bmi) {
        return bmi == IdealBmi.NORMAL;
    }
}
