package bmi.Controller;

import bmi.Entity.*;
import bmi.Entity.NaiveValue.Bmi;
import bmi.Entity.NaiveValue.Height;
import bmi.Entity.NaiveValue.Weight;
import bmi.Interface.TranslatorInterface;
import bmi.Service.Calculator;
import bmi.Service.Translator;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Convert {
    public TextField height, weight;
    public Button btnConvert, btnClear;
    public Label labelHeight, labelWeight, labelResult;

    private Calculator calculator;
    private TranslatorInterface translator;

    public void initialize() {
        calculator = new Calculator();
        translator = new Translator();

        setLabels();
        attacheEventListener();
    }

    private void attacheEventListener() {
        getHeight().textProperty().addListener((observable) -> onConvertAction());
        getWeight().textProperty().addListener((observable) -> onConvertAction());
    }

    public void onClearAction() {
        setLabels();
        clearResult();
    }

    public boolean onConvertAction() {
        return requiredInputIsSet() ? responseSuccess() : responseError();
    }

    //fixme
    private boolean responseSuccess() {
        Weight weight = new Weight(getWeightInput());
        Height height = new Height(getHeightInput());

        Prepare prepare = new Prepare(weight, height);
        getCalculateService().setPrepare(prepare);

        Bmi bmi = new Bmi(getCalculateService().calculateBmi());
        prepare.setBmi(bmi);

        prepare.setIdealWeightForHeight(getCalculateService().getIdealWeightForHeight());
        prepare.setWeightDifference(getCalculateService().getWeightDifference());
        prepare.setClassificationInterface(getCalculateService().getClassificationInterface());

        TextAndStuff textAndStuff = new TextAndStuff(prepare);
        getLabelResult().setText(textAndStuff.resultString());

        if (!getCalculateService().hasIdealBmi()) {
            getLabelResult().setText(textAndStuff.perfectBmi(getLabelResult()));
        }

        return true;
    }

    private TranslatorInterface getTranslator() {
        return translator;
    }

    private String translate(String key) {
        return getTranslator().translate(key);
    }

    private double castStringToDouble(String value) {
        return Double.parseDouble(value.replace(",", "."));
    }

    private boolean responseError() {
        getLabelResult().setText(translate("msg.error"));
        return false;
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

    private TextField getWeight() {
        return weight;
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

    private double getWeightInput() {
        return castStringToDouble(getWeight().getText());
    }

    private boolean requiredInputIsSet() {
        return ((getWeightInput() > 0) && (getHeightInput() > 0));
    }

    private void clearResult() {
        getLabelResult().setText(null);
    }

    private void setLabels() {
        setLabelHeight();
        setLabelWeight();
        setTextFieldDefault(getHeight());
        setTextFieldDefault(getWeight());
        setTextConvertBtn();
        setTextClearBtn();
    }

    private void setLabelHeight() {
        getLabelHeight().setText(translate("label.height"));
    }

    private void setLabelWeight() {
        getLabelWeight().setText(translate("label.weight"));
    }

    private void setTextFieldDefault(TextField t) {
        t.setText(translate("input_placeholder.double_zero"));
    }

    private void setTextConvertBtn() {
        getBtnConvert().setText(translate("btn_label.convert"));
    }

    private void setTextClearBtn() {
        getBtnClear().setText(translate("btn_label.clear"));
    }
}
