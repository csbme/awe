package sample.state;

import javafx.scene.shape.Circle;
import sample.interfaces.StateInterface;

import java.util.ArrayList;

/**
 * The type Yellow.
 */
public class Yellow extends AbstractState implements StateInterface {

    /**
     * Instantiates a new Yellow.
     *
     * @param circles the circles
     */
    public Yellow(ArrayList<Circle> circles) {
        super(circles);
    }

    public int getDuration() {
        return 2;
    }
}
