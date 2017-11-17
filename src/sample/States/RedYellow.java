package sample.States;

import sample.Interfaces.State;

public class RedYellow implements State {
    public String name() {
        return "red/yellow";
    }

    public int durationSeconds() {
        return 1;
    }
}
