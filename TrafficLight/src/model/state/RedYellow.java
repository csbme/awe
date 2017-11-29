package model.state;

import interfaces.StateInterface;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * The type Red yellow.
 */
public class RedYellow extends AbstractState implements StateInterface {

    /**
     * Instantiates a new Red yellow.
     *
     * @param circles the circles
     */
    public RedYellow(ArrayList<Circle> circles) {
        super(circles);
    }

    public int getDuration() {
        return 1;
    }
}
