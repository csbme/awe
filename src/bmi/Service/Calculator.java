package bmi.Service;

import bmi.Constant.ClassificationBmi;
import bmi.Constant.IdealBmi;
import bmi.Entity.*;
import bmi.Interface.ClassificationInterface;
import bmi.Interface.ValueInterface;

import java.util.TreeMap;

public class Calculator {
    private static final double ROUND_FACTOR = 1000.0;

    private Weight weight;
    private Height height;
    private ValueInterface valueInterface;

    private Weight getWeight() {
        return weight;
    }

    private void setWeight(Weight weight) {
        this.weight = weight;
    }

    private Height getHeight() {
        return height;
    }

    private void setHeight(Height height) {
        this.height = height;
    }

    public ValueInterface getBmi() {
        return valueInterface;
    }

    public void setBmi(ValueInterface valueInterface) {
        this.valueInterface = valueInterface;
    }

    public double calculateBmi() {
        return (getWeight().getValue() / (Math.pow(getHeight().getValue(), 2)));
    }

    public double round(double value) {
        return (Math.round(value * ROUND_FACTOR) / ROUND_FACTOR);
    }

    public String classifyWeightHeightRatio() {
        return coolSwitch(getBmi().getValue()).getClassification();
    }

    public double getIdealWeightForHeight() {
        return round(Math.pow(getHeight().getValue(), 2) * coolSwitch(getBmi().getValue()).perfectBmi());
    }

    public double getWeightDifference() {
        return round(getIdealWeightForHeight() - getWeight().getValue());
    }

    public boolean hasIdealBmi() {
        return getBmi().getValue() == IdealBmi.NORMAL;
    }

    public void createWeight(double weight) {
        setWeight(new Weight(weight));
    }

    public void createHeight(double height) {
        setHeight(new Height(height));
    }

    public void createBmi() {
        setBmi(new Bmi(calculateBmi()));
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
