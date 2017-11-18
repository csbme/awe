package sample.States;

import javafx.scene.shape.Circle;
import sample.Interfaces.StateInterface;

import java.util.ArrayList;

public class Red implements StateInterface {
    private ArrayList<Circle> cycles;

    public Red(ArrayList<Circle> cycles) {
        this.cycles = cycles;
    }

    public ArrayList<Circle> getCircles() {
        return cycles;
    }

    public int getDuration() {
        return 2;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
