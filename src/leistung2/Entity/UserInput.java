package leistung2.Entity;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import leistung2.Enum.Units;

public class UserInput {
    private TextField tf_now, tf_previous;
    private ComboBox<Units> cb_now, cb_previous;

    public TextField getTf_now() {
        return tf_now;
    }

    public UserInput setTf_now(TextField tf_now) {
        this.tf_now = tf_now;
        return this;
    }

    public TextField getTf_previous() {
        return tf_previous;
    }

    public UserInput setTf_previous(TextField tf_previous) {
        this.tf_previous = tf_previous;
        return this;
    }

    public ComboBox<Units> getCb_now() {
        return cb_now;
    }

    public UserInput setCb_now(ComboBox<Units> cb_now) {
        this.cb_now = cb_now;
        return this;
    }

    public ComboBox<Units> getCb_previous() {
        return cb_previous;
    }

    @SuppressWarnings("UnusedReturnValue")
    public UserInput setCb_previous(ComboBox<Units> cb_previous) {
        this.cb_previous = cb_previous;
        return this;
    }
}
