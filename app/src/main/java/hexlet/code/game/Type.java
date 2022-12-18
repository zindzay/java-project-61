package hexlet.code.game;

public enum Type {
    UNRECOGNIZED(0),
    GREET(1),
    EVEN(2);

    Type(int value) {
    }

    private static final Type[] VALUES = values();

    public static Type valueOf(int value) {
        return VALUES[value];
    }
}
