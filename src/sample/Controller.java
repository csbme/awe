package sample;

import javafx.scene.shape.Circle;
import sample.Interfaces.TrafficLightInterface;
import sample.Model.TrafficLight;
import sample.States.Green;
import sample.States.Red;
import sample.States.RedYellow;
import sample.States.Yellow;

import java.util.ArrayList;

/**
 * The type Controller.
 */
public class Controller {
    public Circle red, yellow, green;
    private TrafficLightInterface trafficLight;

    /**
     * Initialize.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void initialize() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(red);
        circles.add(yellow);
        circles.add(green);

        trafficLight = new TrafficLight(circles);
        startAction();
    }

    private void startAction() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    execute();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private TrafficLightInterface getTrafficLight() {
        return trafficLight;
    }

    private void execute() throws InterruptedException {
        trafficLightGreen();
        trafficLightYellow();
        trafficLightRed();
        trafficLightRedYellow();
    }

    private void trafficLightGreen() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(green);
        getTrafficLight().setState(new Green(circles));
        getTrafficLight().doAction();
    }

    private void trafficLightYellow() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(yellow);
        getTrafficLight().setState(new Yellow(circles));
        getTrafficLight().doAction();
    }

    private void trafficLightRed() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(red);
        getTrafficLight().setState(new Red(circles));
        getTrafficLight().doAction();
    }

    private void trafficLightRedYellow() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(red);
        circles.add(yellow);
        getTrafficLight().setState(new RedYellow(circles));
        getTrafficLight().doAction();
    }
}
