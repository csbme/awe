package sample.States;

import javafx.scene.shape.Circle;
import sample.Interfaces.StateInterface;

import java.util.ArrayList;

/**
 * The type Green.
 */
public class Green implements StateInterface {
    private ArrayList<Circle> cycles;

    /**
     * Instantiates a new Green.
     *
     * @param cycles the cycles
     */
    public Green(ArrayList<Circle> cycles) {
        this.cycles = cycles;
    }

    public ArrayList<Circle> getCircles() {
        return cycles;
    }

    public int getDuration() {
        return 5;
    }
}
