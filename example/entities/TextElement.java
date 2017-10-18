package entities;

import interfaces.SecondInterface;
import interfaces.RenderableObjectInterface;

/**
 * The type Text element.
 */
public class TextElement implements RenderableObjectInterface, SecondInterface {

    public String render() {
        return "This is a string. \"Hello\" says the sting. What an absolute madman he is!";
    }

    public void example() {
    }
}