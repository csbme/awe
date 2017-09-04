package bmi.Entity;

import bmi.Constant.IdealBmi;
import bmi.Interface.ClassificationInterface;

import java.util.ResourceBundle;

public class NormalWeight implements ClassificationInterface {

    public String getClassification() {
        return ResourceBundle.getBundle("bmi").getString("bmi_classification.normal");
    }

    public double perfectBmi() {
        return IdealBmi.NORMAL;
    }
}
