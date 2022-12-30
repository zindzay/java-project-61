package hexlet.code.menu;

import hexlet.code.Cli;
import hexlet.code.exceptions.UnsupportedGameException;
import hexlet.code.games.CalcGame;
import hexlet.code.games.DivisorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Menu {
    public static Option findGame(Scanner scanner) {
        System.out.println("Please enter the game number and press Enter.\n" + Option.toStringOptions());

        try {
            final var gameNumber = scanner.nextInt();
            System.out.println("Your choice: " + gameNumber);
            return Option.valueOf(gameNumber);
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            throw new UnsupportedGameException();
        }
    }

    public static void playGame(Scanner scanner, Option option) {
        switch (option) {
            case EVEN_GAME -> EvenGame.play(scanner);
            case CALC_GAME -> CalcGame.play(scanner);
            case DIVISOR_GAME -> DivisorGame.play(scanner);
            case PROGRESSION -> ProgressionGame.play(scanner);
            case PRIME -> PrimeGame.play(scanner);
            case GREET -> Cli.findUserName(scanner);
            case EXIT -> {
                // Пользователь решил выйти из игры
            }
            default -> throw new UnsupportedGameException();
        }
    }
}
