package bmi.Controller;

import bmi.Entity.TextAndStuff;
import bmi.Interface.TranslatorInterface;
import bmi.Service.Calculator;
import bmi.Service.Translator;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Convert {
    public TextField height, weight;
    public Button btnConvert, btnClear;
    public Label labelHeight, labelWeight, labelResult;

    private Calculator calculator;
    private TranslatorInterface translator;
    private TextAndStuff textAndStuff;

    public void initialize() {
        calculator = new Calculator();
        textAndStuff = new TextAndStuff();
        translator = new Translator();

        setLabels();
    }

    public void onClear() {
        setLabels();
        clearResult();
    }

    //fixme
    public void onConvert() {
        if (!requiredInputIsSet()) {
            displayError();
        } else {
            getCalculateService().createHeight(getHeightInput());
            getCalculateService().createWeight(getWeightInput());
            getCalculateService().createBmi();

            getLabelResult().setText(getTextAndStuff().resultString(getCalculateService().classifyWeightHeightRatio(), getCalculateService().round(getCalculateService().getBmi().getValue())));

            if (!getCalculateService().hasIdealBmi()) {
                String textPerfectBmi = getTextAndStuff().perfectBmi(getCalculateService().getIdealWeightForHeight(), getCalculateService().getWeightDifference(), getLabelResult());

                getLabelResult().setText(textPerfectBmi);
            }
        }
    }

    private TranslatorInterface getTranslator() {
        return translator;
    }

    private String translate(String key) {
        return getTranslator().translate(key);
    }

    private TextAndStuff getTextAndStuff() {
        return textAndStuff;
    }

    private void clearResult() {
        getLabelResult().setText(null);
    }

    //fixme
    private double castStringToDouble(String value) {
        NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
        Number number = null;

        try {
            number = format.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return number.doubleValue();
    }

    private void displayError() {
        getLabelResult().setText(translate("msg.error"));
    }

    private Button getBtnClear() {
        return btnClear;
    }

    private Button getBtnConvert() {
        return btnConvert;
    }

    private Calculator getCalculateService() {
        return calculator;
    }

    private TextField getHeight() {
        return height;
    }

    private double getHeightInput() {
        return castStringToDouble(getHeight().getText());
    }

    private Label getLabelHeight() {
        return labelHeight;
    }

    private Label getLabelResult() {
        return labelResult;
    }

    private Label getLabelWeight() {
        return labelWeight;
    }

    private TextField getWeight() {
        return weight;
    }

    private double getWeightInput() {
        return castStringToDouble(getWeight().getText());
    }

    private boolean requiredInputIsSet() {
        try {
            return ((getWeightInput() > 0) && (getHeightInput() > 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private void setLabelHeight() {
        getLabelHeight().setText(translate("label.height"));
    }

    private void setLabelWeight() {
        getLabelWeight().setText(translate("label.weight"));
    }

    private void setLabels() {
        setLabelHeight();
        setLabelWeight();
        setTextFieldDefault(getHeight());
        setTextFieldDefault(getWeight());
        setTextConvertBtn();
        setTextClearBtn();
    }

    private void setTextClearBtn() {
        getBtnClear().setText(translate("btn_label.clear"));
    }

    private void setTextConvertBtn() {
        getBtnConvert().setText(translate("btn_label.convert"));
    }

    private void setTextFieldDefault(TextField t) {
        t.setText(translate("input_placeholder.double_zero"));
    }
}
