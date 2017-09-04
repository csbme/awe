package bmi.Entity;

import bmi.Constant.BmiDefinition;
import bmi.Interface.ClassificationInterface;

public class ExtremeObesity implements ClassificationInterface {

    public String getClassification() {
        return BmiDefinition.EXTREME_OBESITY;
    }

    public double perfectBmi() {
        return 24.9;
    }
}
