package bmi.Entity;

import bmi.Interface.ValueInterface;

public class Bmi implements ValueInterface {
    private double value;

    public Bmi(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
