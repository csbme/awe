package sample.Interfaces;

public interface TrafficLightInterface {
    void doAction() throws InterruptedException;

    void setState(StateInterface state);
}
