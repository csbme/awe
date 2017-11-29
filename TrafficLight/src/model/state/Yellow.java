package model.state;

import interfaces.StateInterface;
import javafx.scene.shape.Circle;

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
