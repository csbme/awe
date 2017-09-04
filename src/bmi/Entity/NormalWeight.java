package bmi.Entity;

import bmi.Constant.BmiDefinition;
import bmi.Interface.ClassificationInterface;

public class NormalWeight implements ClassificationInterface {

    public String getClassification() {
        return BmiDefinition.NORMAL;
    }

    public double perfectBmi() {
        return 22.5;
    }
}
