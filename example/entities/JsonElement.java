package entities;

import interfaces.RenderableObjectInterface;

public class JsonElement implements RenderableObjectInterface {

    public String render() {
        return "{\"short\":\"JSON\", \"full\":\"JavaScript Object Notation\", \"url\":\"https://en.wikipedia.org/wiki/JSON\"}";
    }
}
