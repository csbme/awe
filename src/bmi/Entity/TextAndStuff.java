package bmi.Entity;

import bmi.Interface.TranslatorInterface;
import bmi.Service.Translator;
import javafx.scene.control.Label;

public class TextAndStuff {
    private static final String LINE_BREAK_SINGLE = "\n";
    private static final String LINE_BREAK_DOUBLE = "\n\n";
    private static final String SPACE = " ";
    private static final String DOT = ".";
    private static final String COLON = ": ";
    private static final String DIVIDER = " - ";

    private TranslatorInterface translator;
    private Prepare prepare;

    public TextAndStuff(Prepare prepare) {
        this.prepare = prepare;
        this.translator = new Translator();
    }

    private TranslatorInterface getTranslator() {
        return translator;
    }

    private Prepare getPrepare() {
        return prepare;
    }

    private String translate(String key) {
        return getTranslator().translate(key);
    }

    public String perfectBmi(Label labelResult) {
        return labelResult.getText()
                + LINE_BREAK_DOUBLE
                + translate("msg.ideal_weight_at")
                + SPACE
                + getPrepare().getIdealWeightForHeight()
                + translate("msg.kg")
                + SPACE
                + translate("msg.with_weight_change_of")
                + SPACE
                + getPrepare().getWeightDifference()
                + translate("msg.kg")
                + DOT;
    }

    public String resultString() {
        return translate("msg.bmi")
                + COLON
                + SPACE
                + getPrepare().getBmi().getValue()
                + DIVIDER
                + translate(getPrepare().getClassificationInterface().getClassification());
    }
}
