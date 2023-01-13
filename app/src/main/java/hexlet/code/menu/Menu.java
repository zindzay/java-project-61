package hexlet.code.menu;

import hexlet.code.Cli;
import hexlet.code.exceptions.UnsupportedGameException;
import hexlet.code.exceptions.UnsupportedOperationException;
import hexlet.code.games.CalcGame;
import hexlet.code.games.DivisorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import static hexlet.code.Utils.getScanner;

public final class Menu {
    public static void invoke() throws UnsupportedGameException, UnsupportedOperationException {
        System.out.println("Please enter the game number and press Enter.\n" + Option.toStringOptions());

        final var scanner = getScanner();
        final var gameNumber = scanner.nextInt();

        System.out.println("Your choice: " + gameNumber);

        switch (Option.valueOf(gameNumber)) {
            case EVEN_GAME -> EvenGame.play();
            case CALC_GAME -> CalcGame.play();
            case DIVISOR_GAME -> DivisorGame.play();
            case PROGRESSION -> ProgressionGame.play();
            case PRIME -> PrimeGame.play();
            case GREET -> Cli.greet();
            case EXIT -> {
            }
            default -> throw new UnsupportedGameException("Game not found");
        }
    }
}
