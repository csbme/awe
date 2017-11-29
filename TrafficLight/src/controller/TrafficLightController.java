package controller;

import app.Main;
import interfaces.TrafficLightInterface;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import model.state.Green;
import model.state.Red;
import model.state.RedYellow;
import model.state.Yellow;

import java.util.ArrayList;

/**
 * The type Traffic light controller.
 */
public class TrafficLightController {

    /**
     * The Red.
     */
    public Circle red,
    /**
     * The Yellow.
     */
    yellow,
    /**
     * The Green.
     */
    green;
    /**
     * The Text area.
     */
    public TextArea textArea;

    private ArrayList<Circle> circles;
    private TrafficLightInterface trafficLight;

    private boolean isMainThreadRunning = false;
    private Main main;
    private Thread mainThread;

    /**
     * Initialize.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void initialize() throws InterruptedException {
        setCircles();
        setTrafficLight(new model.TrafficLight(getCircles(), getTextArea()));
        startInit();
    }

    private boolean isMainThreadRunning() {
        return isMainThreadRunning;
    }

    private void setMainThreadRunning(boolean mainThreadRunning) {
        isMainThreadRunning = mainThreadRunning;
    }

    private Thread getMainThread() {
        return mainThread;
    }

    private void setMainThread(Thread mainThread) {
        this.mainThread = mainThread;
    }

    private TextArea getTextArea() {
        return textArea;
    }

    private ArrayList<Circle> getCircles() {
        return circles;
    }

    private void setCircles() {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(red);
        circles.add(yellow);
        circles.add(green);

        this.circles = circles;
    }

    private void startInit() throws InterruptedException {
        Runnable runnable = () -> {
            while (isMainThreadRunning()) {
                trafficLightStart();
            }
        };

        setMainThread(new Thread(runnable));
        getMainThread().setDaemon(true);
        setMainThreadRunning(true);
        getMainThread().start();
    }

    /**
     * Start action.
     *
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    protected void startAction() throws InterruptedException {

        if (!isMainThreadRunning()) {
            System.out.println("start");
            startInit();
        }
    }

    /**
     * Stop action.
     */
    @FXML
    protected void stopAction() {

        if (isMainThreadRunning()) {
            System.out.println("stop");
            getMainThread().interrupt();
            setMainThreadRunning(false);
        }
    }

    private void trafficLightStart() {
        try {
            trafficLightProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private TrafficLightInterface getMain() {
        return trafficLight;
    }

    /**
     * Sets main.
     *
     * @param main the main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    private void setTrafficLight(TrafficLightInterface trafficLight) {
        this.trafficLight = trafficLight;
    }

    private void trafficLightProcess() throws InterruptedException {
        trafficLightGreen();
        trafficLightYellow();
        trafficLightRed();
        trafficLightRedYellow();
    }

    private void trafficLightGreen() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(green);
        getMain().setState(new Green(circles));
        getMain().executeState();
    }

    private void trafficLightYellow() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(yellow);
        getMain().setState(new Yellow(circles));
        getMain().executeState();
    }

    private void trafficLightRed() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(red);
        getMain().setState(new Red(circles));
        getMain().executeState();
    }

    private void trafficLightRedYellow() throws InterruptedException {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(red);
        circles.add(yellow);
        getMain().setState(new RedYellow(circles));
        getMain().executeState();
    }
}
