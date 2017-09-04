package bmi.Entity;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

import java.util.ResourceBundle;

public class Underweight implements ClassificationInterface {

    public String getClassification() {
        return ResourceBundle.getBundle("bmi").getString("bmi_classification.underweight");
    }

    public double perfectBmi() {
        return IdealBmi.UNDERWEIGHT;
    }
}
