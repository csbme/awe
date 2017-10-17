import entities.JsonElement;
import entities.TextElement;
import interfaces.RenderableObjectInterface;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        someMethod(new JsonElement());
        someMethod(new TextElement());
    }

    private static void someMethod(RenderableObjectInterface renderableObject) {
        System.out.println(renderableObject.render());
    }
}
