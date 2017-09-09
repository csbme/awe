package bmi.Entity.NaiveValue;

import bmi.Interface.ValueInterface;

public class Height implements ValueInterface {
    private double value;

    public Height(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
