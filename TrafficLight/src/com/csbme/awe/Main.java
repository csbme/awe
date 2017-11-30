package com.csbme.awe;

import com.csbme.awe.controller.RootLayoutController;
import com.csbme.awe.controller.TrafficLightController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Main.
 */
public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private RootLayoutController rootLayoutController;
    private TrafficLightController trafficLightController;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {
        launch(args);
    }

    /**
     * Gets primary stage.
     *
     * @return the primary stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Traffic Light Simulator 3000 'Final Apex Elite'-Edition");

        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("images/Java.png"));
        primaryStage.setResizable(false);

        initRootLayout();
        showTrafficLight();

        // Allow TrafficLightController methods to be called in RootLayoutController
        getRootLayoutController().setTrafficLightController(getTrafficLightController());
    }

    private RootLayoutController getRootLayoutController() {
        return rootLayoutController;
    }

    private void setRootLayoutController(RootLayoutController rootLayoutController) {
        this.rootLayoutController = rootLayoutController;
    }

    private TrafficLightController getTrafficLightController() {
        return trafficLightController;
    }

    private void setTrafficLightController(TrafficLightController trafficLightController) {
        this.trafficLightController = trafficLightController;
    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the app app.
            RootLayoutController controller = loader.getController();
            setRootLayoutController(controller);
            controller.setMain(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showTrafficLight() {
        try {
            // Load overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/TrafficLight.fxml"));
            AnchorPane trafficLight = loader.load();

            // Set trafficLight into the center of root layout.
            rootLayout.setCenter(trafficLight);

            // Give the controller access to the app app.
            TrafficLightController controller = loader.getController();
            setTrafficLightController(controller);
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
