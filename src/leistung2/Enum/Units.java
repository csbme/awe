package leistung2.Enum;

public enum Units {
    PS("PS"),
    HP("HP"),
    KW("KW");

    private final String name;

    Units(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}