package sample.Model;

import javafx.scene.shape.Circle;
import sample.Interfaces.StateInterface;
import sample.Interfaces.TrafficLightInterface;

import java.util.ArrayList;

import static sample.Service.ConverterService.secondsToNanoseconds;

/**
 * The type Traffic light.
 */
public class TrafficLight implements TrafficLightInterface {
    private StateInterface state;
    private ArrayList<Circle> cycles;

    /**
     * Instantiates a new Traffic light.
     *
     * @param cycles the cycles
     */
    public TrafficLight(ArrayList<Circle> cycles) {
        this.cycles = cycles;
    }

    public void doAction() throws InterruptedException {
        // set all circles invisible
        setAllCirclesInvisible();

        // show state in UI
        for (Circle circle : getState().getCircles()) {
            circle.setVisible(true);
        }

        // print state name
        System.out.println(getState().getClass().getSimpleName());

        // show state for x seconds
        Thread.sleep(secondsToNanoseconds(getState().getDuration()));
    }

    /**
     * Gets circles.
     *
     * @return the circles
     */
    private ArrayList<Circle> getCircles() {
        return cycles;
    }

    private StateInterface getState() {
        return this.state;
    }

    public void setState(StateInterface state) {
        this.state = state;
    }

    private void setAllCirclesInvisible() {
        for (Circle circle : getCircles()) {
            circle.setVisible(false);
        }
    }
}
