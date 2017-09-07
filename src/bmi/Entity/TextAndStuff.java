package bmi.Entity;

import bmi.Interface.TranslatorInterface;
import javafx.scene.control.Label;

public class TextAndStuff {
    private static final String LINE_BREAK_SINGLE = "\n";
    private static final String LINE_BREAK_DOUBLE = "\n\n";
    private static final String SPACE = " ";
    private static final String DOT = ".";
    private static final String COLON = ": ";
    private static final String DIVIDER = " - ";

    private TranslatorInterface translator;

    private TranslatorInterface getTranslator() {
        return translator;
    }

    private String translate(String key) {
        return getTranslator().translate(key);
    }

    public String perfectBmi(double idealWeightForHeight, double weightDifference, Label labelResult) {
        return labelResult.getText()
                + LINE_BREAK_DOUBLE
                + translate("msg.ideal_weight_at")
                + SPACE
                + idealWeightForHeight
                + translate("msg.kg")
                + SPACE
                + translate("msg.with_weight_change_of")
                + SPACE
                + weightDifference
                + translate("msg.kg")
                + DOT;
    }

    public String resultString(String classifyWeightHeightRatio, double bmi) {
        return translate("msg.bmi")
                + COLON
                + SPACE
                + bmi
                + DIVIDER
                + classifyWeightHeightRatio;
    }
}
