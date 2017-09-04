package bmi.Entity;

import bmi.Constant.BmiDefinition;
import bmi.Interface.ClassificationInterface;

public class SevereObesity implements ClassificationInterface {

    public String getClassification() {
        return BmiDefinition.SEVERE_OBESITY;
    }

    public double perfectBmi() {
        return 24.9;
    }
}
