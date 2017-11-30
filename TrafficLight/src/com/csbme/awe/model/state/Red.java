package com.csbme.awe.model.state;

import com.csbme.awe.interfaces.StateInterface;
import javafx.scene.shape.Circle;

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
