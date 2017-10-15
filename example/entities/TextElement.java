package entities;

import interfaces.RenderableObjectInterface;

public class TextElement implements RenderableObjectInterface {

    public String render() {
        return "This is a string. \"Hello\" says the sting. What an absolute madman he is!";
    }
}