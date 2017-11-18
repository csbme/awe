package sample.States;

import javafx.scene.shape.Circle;
import sample.Interfaces.StateInterface;

import java.util.ArrayList;

/**
 * The type Red.
 */
public class Red implements StateInterface {
    private ArrayList<Circle> cycles;

    /**
     * Instantiates a new Red.
     *
     * @param cycles the cycles
     */
    public Red(ArrayList<Circle> cycles) {
        this.cycles = cycles;
    }

    public ArrayList<Circle> getCircles() {
        return cycles;
    }

    public int getDuration() {
        return 2;
    }
}
