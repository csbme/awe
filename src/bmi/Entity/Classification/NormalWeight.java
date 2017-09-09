package bmi.Entity.Classification;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

public class NormalWeight implements ClassificationInterface {

    public String getClassification() {
        return "bmi_classification.normal";
    }

    public double perfectBmi() {
        return IdealBmi.NORMAL;
    }
}
