package bmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/converter.fxml"));
        primaryStage.setTitle("Ultimate Science Converter 3001 (Certified Apex-Plus-BMI Edition)");
        primaryStage.setScene(new Scene(root, 500, 200));
        primaryStage.show();
    }
}
