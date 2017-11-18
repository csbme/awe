package sample.Interfaces;

/**
 * The interface Traffic light interface.
 */
public interface TrafficLightInterface {
    /**
     * Do action.
     *
     * @throws InterruptedException the interrupted exception
     */
    void doAction() throws InterruptedException;

    /**
     * Sets state.
     *
     * @param state the state
     */
    void setState(StateInterface state);
}
