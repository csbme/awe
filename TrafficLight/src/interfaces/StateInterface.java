package interfaces;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * The interface State interface.
 */
public interface StateInterface {
    /**
     * Gets circles.
     *
     * @return the circles
     */
    ArrayList<Circle> getCircles();

    /**
     * Gets duration.
     *
     * @return the duration
     */
    int getDuration();
}
