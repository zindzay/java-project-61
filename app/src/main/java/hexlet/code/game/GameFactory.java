package hexlet.code.game;

import java.util.Scanner;

public final class GameFactory {
    private GameFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Game create(Type type, String userName, Scanner scanner) {
        if (type == Type.EVEN) {
            return new EvenGame(userName, scanner);
        }

        throw new UnsupportedGameException();
    }
}
