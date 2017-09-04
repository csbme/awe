package bmi.Entity;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

import java.util.ResourceBundle;

public class ExtremeObesity implements ClassificationInterface {

    public String getClassification() {
        return ResourceBundle.getBundle("bmi").getString("bmi_classification.extreme_obesity");
    }

    public double perfectBmi() {
        return IdealBmi.OVERWEIGHT;
    }
}
