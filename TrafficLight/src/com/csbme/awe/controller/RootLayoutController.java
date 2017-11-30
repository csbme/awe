package com.csbme.awe.controller;

import com.csbme.awe.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * The type Root layout controller.
 */
public class RootLayoutController {

    private Main main;
    private TrafficLightController trafficLightController;

    /**
     * Sets main.
     *
     * @param main the main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Sets traffic light controller.
     *
     * @param trafficLightController the traffic light controller
     */
    public void setTrafficLightController(TrafficLightController trafficLightController) {
        this.trafficLightController = trafficLightController;
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Traffic Light Simulator 3000 'Final Apex Elite'-Edition");
        alert.setHeaderText("About");
        alert.setContentText("\"You don’t need to go to church to be a Christian. If you go to Taco Bell, that doesn’t make you a taco.\"\n\n- Justin Bieber");

        alert.showAndWait();
    }

    @FXML
    private void startAction() throws InterruptedException {
        this.trafficLightController.startAction();
    }

    /**
     * Stop action.
     */
    @FXML
    protected void stopAction() {
        this.trafficLightController.stopAction();
    }
}
