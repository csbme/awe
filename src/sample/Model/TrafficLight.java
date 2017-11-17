package sample.Model;

import sample.Interfaces.State;
import sample.Interfaces.TrafficLightInterface;
import static sample.Service.ConverterService.secondsToNanoseconds;

public class TrafficLight implements TrafficLightInterface {
    private State state;

    public void doAction() throws InterruptedException {
        // print state name
        System.out.println(this.state.name());
        // sleep for state durationSeconds
        Thread.sleep(secondsToNanoseconds(this.state.durationSeconds()));
    }

    public void setState(State state) {
        this.state = state;
    }
}
