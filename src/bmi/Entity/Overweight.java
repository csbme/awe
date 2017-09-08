package bmi.Entity;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

public class Overweight implements ClassificationInterface {

    public String getClassification() {
        return "bmi_classification.overweight";
    }

    public double perfectBmi() {
        return IdealBmi.OVERWEIGHT;
    }
}
