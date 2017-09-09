package bmi.Entity.Classification;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

public class SevereObesity implements ClassificationInterface {

    public String getClassification() {
        return "bmi_classification.severe_obesity";
    }

    public double perfectBmi() {
        return IdealBmi.OVERWEIGHT;
    }
}
