package com.csbme.awe;

import com.csbme.awe.controller.RecordEditDialogController;
import com.csbme.awe.controller.RecordOverviewController;
import com.csbme.awe.controller.RootLayoutController;
import com.csbme.awe.model.Record;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Record> recordData = FXCollections.observableArrayList();

    public MainApp() {
        // Add some sample data
        recordData.add(new Record("Algebra", "1"));
        recordData.add(new Record("Bio", "2"));
        recordData.add(new Record("Chemie", "3"));
        recordData.add(new Record("Deutsch", "4"));
        recordData.add(new Record("Erdkunde", "5"));
        recordData.add(new Record("Film", "6"));
    }

    /**
     * Connect to a sample database
     */
    public static void createNewDatabase() {

        String url = "jdbc:sqlite:sqlite.db";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewDatabase();
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Record> getRecordData() {
        return recordData;
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPersonEditDialog(Record record) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RecordEditDialog.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Record");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the record into the controller.
            RecordEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setRecord(record);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RecordOverview.fxml"));
            AnchorPane personOverview = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            RecordOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Spectacular Meltdown");

        initRootLayout();
        showPersonOverview();
    }
}