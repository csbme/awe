package bmi.Controller;

import bmi.Service.Calculate;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Convert {
    private static final String LINE_BREAK_SINGLE = "\n";
    private static final String LINE_BREAK_DOUBLE = "\n\n";
    private static final String SPACE = " ";
    private static final String DOT = ".";
    public static final String COLON = ": ";
    public static final String DEVIDER = " - ";

    public TextField height, weight;
    public Button btn_convert, btn_clear;
    public Label label_height, label_weight, result;
    private Calculate calculate;

    private ResourceBundle msg;

    private String getTranslation(String key) {
        return msg.getString(key);
    }

    public void onClear() {
        setLabels();
        getResult().setText(null);
    }

    public void initialize() {
        calculate = new Calculate();
        msg = ResourceBundle.getBundle("bmi");
        setLabels();
    }

    private Calculate getCalculateService() {
        return calculate;
    }

    private TextField getHeight() {
        return height;
    }

    private TextField getWeight() {
        return weight;
    }

    private Button getBtn_convert() {
        return btn_convert;
    }

    private Button getBtn_clear() {
        return btn_clear;
    }

    private Label getResult() {
        return result;
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

    private double getHeightInput() {
        return castStringToDouble(getHeight().getText());
    }

    private double getWeightInput() {
        return castStringToDouble(getWeight().getText());
    }

    private double getBmi() {
        double bmi = getCalculateService().calculateBmi(getWeightInput(), getHeightInput());
        return getCalculateService().round(bmi);
    }

    public void onConvert() {
        if (!requiredInputIsSet()) {
            displayError();
        } else {
            getResult().setText(resultString());

            if (!getCalculateService().hasIdealBmi(getBmi())) {
                getResult().setText(perfectBmi());
            }
        }
    }

    private String resultString() {
        return getTranslation("msg.bmi")
                + COLON
                + SPACE
                + getBmi()
                + DEVIDER
                + getCalculateService().classifyTest(getBmi());
    }

    private String perfectBmi() {
        return getResult().getText()
                + LINE_BREAK_DOUBLE
                + getTranslation("msg.ideal_weight_at")
                + SPACE
                + getCalculateService().getIdealWeightForHeight(getHeightInput(), getBmi())
                + getTranslation("msg.kg")
                + SPACE
                + getTranslation("msg.with_weight_change_of")
                + SPACE
                + getCalculateService().getWeightDifference(getHeightInput(), getBmi(), getWeightInput())
                + getTranslation("msg.kg")
                + DOT;
    }

    private void displayError() {
        getResult().setText(getTranslation("msg.error"));
    }

    private boolean requiredInputIsSet() {
        try {
            return ((getWeightInput() > 0) && (getHeightInput() > 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private void setLabels() {
        setLabelHeight();
        setLabelWeight();
        setTextFieldDefault(getHeight());
        setTextFieldDefault(getWeight());
        setTextConvertBtn();
        setTextClearBtn();
    }

    private Label getLabel_height() {
        return label_height;
    }

    private Label getLabel_weight() {
        return label_weight;
    }

    private void setTextClearBtn() {
        getBtn_clear().setText(getTranslation("btn_label.clear"));
    }

    private void setTextConvertBtn() {
        getBtn_convert().setText(getTranslation("btn_label.convert"));
    }

    private void setLabelHeight() {
        getLabel_height().setText(getTranslation("label.height"));
    }

    private void setLabelWeight() {
        getLabel_weight().setText(getTranslation("label.weight"));
    }

    private void setTextFieldDefault(TextField t) {
        t.setText(getTranslation("input_placeholder.double_zero"));
    }
}
