package sample.States;

import javafx.scene.shape.Circle;
import sample.Interfaces.StateInterface;

import java.util.ArrayList;

/**
 * The type Red yellow.
 */
public class RedYellow implements StateInterface {
    private ArrayList<Circle> cycles;

    /**
     * Instantiates a new Red yellow.
     *
     * @param cycles the cycles
     */
    public RedYellow(ArrayList<Circle> cycles) {
        this.cycles = cycles;
    }

    public ArrayList<Circle> getCircles() {
        return cycles;
    }

    public int getDuration() {
        return 1;
    }
}
