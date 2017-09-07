package bmi.Entity;

import bmi.Interface.ValueInterface;

public class Weight implements ValueInterface{
    private double value;

    public Weight(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
