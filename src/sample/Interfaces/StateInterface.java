package sample.Interfaces;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

public interface StateInterface {
    ArrayList<Circle> getCircles();

    int getDuration();

    String getName();
}
