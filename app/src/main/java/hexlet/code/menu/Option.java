package hexlet.code.menu;

import hexlet.code.exceptions.UnsupportedGameException;

public enum Option {
    EXIT(0, "Exit"),
    GREET(1, "Greet"),
    EVEN_GAME(2, "Even"),
    CALC_GAME(3, "Calc"),
    DIVISOR_GAME(4, "Divisor"),
    PROGRESSION(5, "Progression"),
    PRIME(6, "Prime");

    private final int id;
    private final String description;

    Option(final int newId, final String newDescription) {
        this.id = newId;
        this.description = newDescription;
    }

    private static final Option[] VALUES = values();

    public static Option valueOf(final int id) {
        try {
            return VALUES[id];
        } catch (Exception e) {
            throw new UnsupportedGameException("Game not found");
        }
    }

    public static String toStringOptions() {
        final var sb = new StringBuilder();

        for (final var value : VALUES) {
            sb.append(value.id).append(" - ").append(value.description).append("\n");
        }

        return sb.toString();
    }
}
