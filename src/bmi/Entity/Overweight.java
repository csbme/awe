package bmi.Entity;

import bmi.Constant.BmiDefinition;
import bmi.Interface.ClassificationInterface;

public class Overweight implements ClassificationInterface {

    public String getClassification() {
        return BmiDefinition.OVERWEIGHT;
    }

    public double perfectBmi() {
        return 24.9;
    }
}
