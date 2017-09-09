package bmi.Entity.Classification;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

public class ExtremeObesity implements ClassificationInterface {

    public String getClassification() {
        return "bmi_classification.extreme_obesity";
    }

    public double perfectBmi() {
        return IdealBmi.OVERWEIGHT;
    }
}
