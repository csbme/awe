package model;

import interfaces.StateInterface;
import interfaces.TrafficLightInterface;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import service.ConverterService;

import java.util.ArrayList;

/**
 * The type Traffic light.
 */
public class TrafficLight implements TrafficLightInterface {
    private StateInterface state;
    private ArrayList<Circle> cycles;
    private TextArea textArea;

    /**
     * Instantiates a new Traffic light.
     *
     * @param cycles   the cycles
     * @param textArea the text area
     */
    public TrafficLight(ArrayList<Circle> cycles, TextArea textArea) {
        this.cycles = cycles;
        this.textArea = textArea;
    }

    public void executeState() throws InterruptedException {
        // set all circles invisible
        setAllCirclesInvisible();

        // set provided circles visible
        getState().getCircles().forEach(circle -> circle.setVisible(true));

        // print model.state name
        int delayInSeconds = (getState().getDuration());
        textArea.appendText(getState().getClass().getSimpleName() + ": " + delayInSeconds + " seconds" + "\n");

        // show current model.state for x seconds
        try {
            Thread.sleep(ConverterService.secondsToNanoseconds(delayInSeconds));
        } catch (InterruptedException e) {

            e.printStackTrace();
            System.out.println("interrupt");
            Thread.currentThread().interrupt();
            getState().getCircles().forEach(circle -> circle.setVisible(false));
        }
    }

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
        getCircles().forEach(circle -> circle.setVisible(false));
    }
}
