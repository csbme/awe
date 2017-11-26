package sample.state;

import javafx.scene.shape.Circle;
import sample.interfaces.StateInterface;

import java.util.ArrayList;

/**
 * The type Red.
 */
public class Red extends AbstractState implements StateInterface {

    /**
     * Instantiates a new Red.
     *
     * @param circles the circles
     */
    public Red(ArrayList<Circle> circles) {
        super(circles);
    }

    public int getDuration() {
        return 3;
    }
}
