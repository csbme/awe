package model.state;

import interfaces.StateInterface;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * The type Green.
 */
public class Green extends AbstractState implements StateInterface {

    /**
     * Instantiates a new Green.
     *
     * @param circles the circles
     */
    public Green(ArrayList<Circle> circles) {
        super(circles);
    }

    public int getDuration() {
        return 5;
    }
}
