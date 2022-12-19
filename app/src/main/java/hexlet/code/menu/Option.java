package hexlet.code.menu;

public enum Option {
    UNRECOGNIZED(0, "Exit"),
    GREET(1, "Greet"),
    EVEN_GAME(2, "Even"),
    CALC_GAME(3, "Calc"),
    DIVISOR_GAME(4, "Divisor"),
    PROGRESSION(5, "Progression"),
    PRIME(6, "Prime");

    private final int id;
    private final String description;

    Option(int id, String description) {
        this.id = id;
        this.description = description;
    }

    private static final Option[] VALUES = values();

    public static Option valueOf(int id) {
        return VALUES[id];
    }

    public static String toStringOptions() {
        final var sb = new StringBuilder();

        for (var value : VALUES) {
            sb.append(value.id).append(" - ").append(value.description).append("\n");
        }

        return sb.toString();
    }
}
