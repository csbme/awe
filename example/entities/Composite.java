package entities;

import interfaces.ComponentInterface;
import java.util.ArrayList;
import java.util.List;
import static Services.Random.randomInt;

/**
 * The type Composite.
 */
public class Composite implements ComponentInterface {

    private final String name;
    private List<ComponentInterface> componentList = new ArrayList<ComponentInterface>();

    /**
     * Instantiates a new Composite.
     */
    public Composite() {
        this.name = String.valueOf(randomInt());
    }

    /**
     * Instantiates a new Composite.
     *
     * @param name the name
     */
    public Composite(String name) {
        this.name = name;
    }

    /**
     * Add.
     *
     * @param renderableObject the renderable object
     */
    public void add(ComponentInterface renderableObject) {
        componentList.add(renderableObject);
    }

    public String render() {
        StringBuilder result = new StringBuilder();

        for (ComponentInterface renderableObject : componentList) {
            result.append(renderableObject.render()).append("\n");
        }

        return "Composite #" + getName() + " here.\n" + result.toString();
    }

    private String getName() {
        return name;
    }
}
