package Services;

/**
 * The type Random.
 */
public final class Random {

    /**
     * Random int int.
     *
     * @return the int
     */
    public static int randomInt() {
        return (new java.util.Random()).nextInt(100);
    }
}
