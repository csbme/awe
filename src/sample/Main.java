package sample;

import sample.Model.TrafficLight;
import sample.States.Green;
import sample.States.Red;
import sample.States.RedYellow;
import sample.States.Yellow;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TrafficLight trafficLight = new TrafficLight();

        while (true) {
            execute(trafficLight);
        }
    }

    private static void execute(TrafficLight trafficLight) throws InterruptedException {
        trafficLight.setState(new Green());
        trafficLight.doAction();
        trafficLight.setState(new Yellow());
        trafficLight.doAction();
        trafficLight.setState(new Red());
        trafficLight.doAction();
        trafficLight.setState(new RedYellow());
        trafficLight.doAction();
    }
}
