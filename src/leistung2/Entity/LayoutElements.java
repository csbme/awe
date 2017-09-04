package leistung2.Entity;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import leistung2.Enum.Units;

public class LayoutElements {
    public ComboBox<Units> cb_choice_1, cb_choice_2;
    public TextField tf_1, tf_2;
    public Button btn_convert, btn_clear;
    private UserInput userInput;

    protected ComboBox<Units> getCb_choice_1() {
        return cb_choice_1;
    }

    protected ComboBox<Units> getCb_choice_2() {
        return cb_choice_2;
    }

    protected TextField getTf_1() {
        return tf_1;
    }

    protected TextField getTf_2() {
        return tf_2;
    }

    protected Button getBtn_convert() {
        return btn_convert;
    }

    protected Button getBtn_clear() {
        return btn_clear;
    }

    protected UserInput getUserInput() {
        return userInput;
    }

    protected void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }
}
