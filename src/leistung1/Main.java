package leistung1;

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
        Parent root = FXMLLoader.load(getClass().getResource("psToKw.fxml"));
        primaryStage.setTitle("PS -> kW");
        primaryStage.setScene(new Scene(root, 600, 75));
        primaryStage.show();
    }
}
