package sample.States;

import sample.Interfaces.State;

public class Yellow implements State {
    public String name() {
        return "yellow";
    }

    public int durationSeconds() {
        return 1;
    }
}
