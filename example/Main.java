import entities.Composite;
import entities.Leaf;

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

        System.out.println(firstExample());
    }

    private static String firstExample() {
        // Eine leere Komposition
        Composite composite = new Composite();

        return composite.render();
    }

    private static String secondExample() {
        Composite composite = new Composite();

        Leaf leaf_1 = new Leaf();
        Leaf leaf_2 = new Leaf();

        // Blätter werden der Komposition hinzugefügt
        composite.add(leaf_1);
        composite.add(leaf_2);

        return composite.render();
    }

    private static String thirdExample() {
        Composite composite_1 = new Composite();
        Composite composite_2 = new Composite();

        // Kompositionen können zusätzliche Kompositionen beinhalten
        composite_1.add(composite_2);

        return composite_1.render();
    }

    private static String fourthExample() {
        Composite composite_1 = new Composite();
        Composite composite_2 = new Composite();

        Leaf leaf_1 = new Leaf();
        Leaf leaf_2 = new Leaf();

        composite_1.add(leaf_1);

        composite_2.add(leaf_1);
        composite_2.add(leaf_2);

        // Kompositionen und Blätter sind durch die Wurzel-Komponente (ComponentInterface) definiert.
        // Sie können alle Objekte beinhalten, die das Interface implementieren.
        composite_1.add(composite_2);

        return composite_1.render();
    }

    private static String myLittleStackOverflow() {
        Composite composite = new Composite();
        composite.add(composite);

        return composite.render();
    }
}
