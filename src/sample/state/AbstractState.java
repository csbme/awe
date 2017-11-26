package sample.state;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * The type Abstract state.
 */
public abstract class AbstractState {
    private ArrayList<Circle> circles;

    /**
     * Instantiates a new Abstract state.
     *
     * @param circles the circles
     */
    AbstractState(ArrayList<Circle> circles) {
        this.circles = circles;
    }

    /**
     * Gets circles.
     *
     * @return the circles
     */
    public ArrayList<Circle> getCircles() {
        return circles;
    }
}
