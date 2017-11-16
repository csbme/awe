package entities;

import interfaces.ComponentInterface;
import static Services.Random.randomInt;

/**
 * The type Leaf.
 */
public class Leaf implements ComponentInterface {
    private final String name;

    /**
     * Instantiates a new Leaf.
     */
    public Leaf() {
        this.name = String.valueOf(randomInt());
    }

    /**
     * Instantiates a new Leaf.
     *
     * @param name the name
     */
    public Leaf(String name) {
        this.name = name;
    }

    public String render() {
        return "\"Hello\" says leaf #" + getName() + ".";
    }

    private String getName() {
        return name;
    }
}