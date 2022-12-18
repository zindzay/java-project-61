package hexlet.code.menu;

public enum Option {
    UNRECOGNIZED(0),
    GREET(1),
    EVEN_GAME(2),
    CALC_GAME(3);

    Option(int value) {
    }

    private static final Option[] VALUES = values();

    public static Option valueOf(int value) {
        return VALUES[value];
    }
}
