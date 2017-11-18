package sample;

import javafx.scene.shape.Circle;
import sample.Interfaces.TrafficLightInterface;
import sample.Model.TrafficLight;
import sample.States.Green;
import sample.States.Red;
import sample.States.RedYellow;
import sample.States.Yellow;

import java.util.ArrayList;

public class Controller {
    public Circle red, yellow, green;
    private TrafficLightInterface trafficLight;

    public void initialize() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(red);
        circles.add(yellow);
        circles.add(green);

        trafficLight = new TrafficLight(circles);
        startAction();
    }

    public void startAction() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        execute(getTrafficLight());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    private TrafficLightInterface getTrafficLight() {
        return trafficLight;
    }

    private void execute(TrafficLightInterface trafficLight) throws InterruptedException {
        ArrayList<Circle> circle_1 = new ArrayList<>();
        circle_1.add(green);
        trafficLight.setState(new Green(circle_1));
        trafficLight.doAction();

        ArrayList<Circle> circle_2 = new ArrayList<>();
        circle_2.add(yellow);
        trafficLight.setState(new Yellow(circle_2));
        trafficLight.doAction();

        ArrayList<Circle> circle_3 = new ArrayList<>();
        circle_3.add(red);
        trafficLight.setState(new Red(circle_3));
        trafficLight.doAction();

        ArrayList<Circle> circle_4 = new ArrayList<>();
        circle_4.add(red);
        circle_4.add(yellow);
        trafficLight.setState(new RedYellow(circle_4));
        trafficLight.doAction();
    }
}
