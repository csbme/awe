package sample.States;

import sample.Interfaces.State;

public class Green implements State {
    public String name() {
        return "green";
    }

    public int durationSeconds() {
        return 4;
    }
}
