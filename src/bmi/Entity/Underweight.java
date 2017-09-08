package bmi.Entity;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

public class Underweight implements ClassificationInterface {

    public String getClassification() {
        return "bmi_classification.underweight";
    }

    public double perfectBmi() {
        return IdealBmi.UNDERWEIGHT;
    }
}
