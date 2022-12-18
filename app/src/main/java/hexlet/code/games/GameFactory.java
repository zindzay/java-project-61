package hexlet.code.games;

import hexlet.code.menu.Option;

import java.util.Scanner;

public final class GameFactory {
    private GameFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Game create(Option option, String userName, Scanner scanner) {
        return switch (option) {
            case EVEN_GAME -> new EvenGame(userName, scanner);
            case CALC_GAME -> new CalcGame(userName, scanner);
            case DIVISOR_GAME -> new DivisorGame(userName, scanner);
            default -> null;
        };
    }
}
