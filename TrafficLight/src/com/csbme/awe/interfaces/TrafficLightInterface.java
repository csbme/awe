package com.csbme.awe.interfaces;

/**
 * The interface Traffic light interface.
 */
public interface TrafficLightInterface {
    /**
     * Execute state.
     *
     * @throws InterruptedException the interrupted exception
     */
    void executeState() throws InterruptedException;

    /**
     * Sets state.
     *
     * @param state the state
     */
    void setState(StateInterface state);
}
