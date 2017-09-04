package leistung1;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private final double KW_TO_PS = 1.3596216;

    public TextField tf_ps;
    public Label l_kw;

    public void onConvert(ActionEvent actionEvent) {
        String psString = tf_ps.getText();
        Double psValue = Double.parseDouble(psString);
        l_kw.setText(String.valueOf(this.round(this.convertPsToKw(psValue))));
    }

    public void onClear(ActionEvent actionEvent) {
        tf_ps.clear();
        l_kw.setText(null);
    }

    private double convertPsToKw(double ps){
        return (ps/this.KW_TO_PS);
    }

    private double round(double value){
        return (Math.round(value*100.0)/100.0);
    }
}
