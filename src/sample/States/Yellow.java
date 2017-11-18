package sample.States;

import javafx.scene.shape.Circle;
import sample.Interfaces.StateInterface;

import java.util.ArrayList;

/**
 * The type Yellow.
 */
public class Yellow implements StateInterface {
    private ArrayList<Circle> cycles;

    /**
     * Instantiates a new Yellow.
     *
     * @param cycles the cycles
     */
    public Yellow(ArrayList<Circle> cycles) {
        this.cycles = cycles;
    }

    public ArrayList<Circle> getCircles() {
        return cycles;
    }

    public int getDuration() {
        return 2;
    }
}
