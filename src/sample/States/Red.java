package sample.States;

import sample.Interfaces.State;

public class Red implements State {
    public String name() {
        return "red";
    }

    public int durationSeconds() {
        return 3;
    }
}
