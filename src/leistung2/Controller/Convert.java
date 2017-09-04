package leistung2.Controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import leistung2.Entity.LayoutElements;
import leistung2.Entity.UserInput;
import leistung2.Enum.Units;
import leistung2.Service.Calculate;
import leistung2.Service.Localize;

public class Convert extends LayoutElements {

    public void initialize() {
        setUserInput(new UserInput());
        setListener();
        setLabels();
        onClear();
    }

    public void onClear() {
        setTextFieldDefault(getTf_1());
        setTextFieldDefault(getTf_2());
        setComboxDefault(getCb_choice_1());
        setComboxDefault(getCb_choice_2());
    }

    public void onConvert() {
        // Get user string input.
        String cb_now = getUserInput().getCb_now().getValue().toString();
        String cb_previous = getUserInput().getCb_previous().getValue().toString();

        // Parse user string input to enum value.
        Units cb_now_enum = Units.valueOf(cb_now);
        Units cb_previous_enum = Units.valueOf(cb_previous);

        // Get user string input as double.
        Double tf_now = Double.parseDouble(getUserInput().getTf_now().getText());

        Double factor = Calculate.returnFactorValue(cb_now_enum, cb_previous_enum);
        Double round = Calculate.round(Calculate.convert(tf_now, factor));

        getUserInput().getTf_previous().setText(String.valueOf(round));
    }

    private void setListener() {
        getTf_1().textProperty().addListener((observable) -> setValueFields1());
        getTf_2().textProperty().addListener((observable) -> setValueFields2());

        getCb_choice_1().valueProperty().addListener((observable) -> setValueFields2());
        getCb_choice_2().valueProperty().addListener((observable) -> setValueFields1());
    }

    private void setLabels() {
        getCb_choice_1().setPromptText(Localize.msg("placeholder_choose"));
        getCb_choice_2().setPromptText(Localize.msg("placeholder_choose"));
        getBtn_convert().setText(Localize.msg("btn_convert"));
        getBtn_clear().setText(Localize.msg("btn_clear"));
    }

    private void setValueFields1() {
        getUserInput()
                .setTf_now(getTf_1())
                .setTf_previous(getTf_2())
                .setCb_now(getCb_choice_1())
                .setCb_previous(getCb_choice_2());
    }

    private void setValueFields2() {
        getUserInput().setTf_now(getTf_2())
                .setTf_previous(getTf_1())
                .setCb_now(getCb_choice_2())
                .setCb_previous(getCb_choice_1());
    }


    private void setTextFieldDefault(TextField t) {
        t.setText("0.0");
    }

    private void setComboxDefault(ComboBox<Units> c) {
        c.setPromptText(Localize.msg("placeholder_choose"));
        c.getItems().clear();
        c.getItems().addAll(Units.PS, Units.KW, Units.HP);
    }
}
