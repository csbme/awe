package bmi.Entity;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

import java.util.ResourceBundle;

public class Overweight implements ClassificationInterface {

    public String getClassification() {
        return ResourceBundle.getBundle("bmi").getString("bmi_classification.overweight");
    }

    public double perfectBmi() {
        return IdealBmi.OVERWEIGHT;
    }
}
