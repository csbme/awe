package bmi.Entity;

import bmi.Constant.BmiDefinition;
import bmi.Interface.ClassificationInterface;

public class Underweight implements ClassificationInterface {
    public double perfectBmi() {
        return 20;
    }

    public String getClassification() {
        return BmiDefinition.UNDERWEIGHT;
    }
}
