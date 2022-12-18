package hexlet.code.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Menu {
    private Menu() {
        throw new IllegalStateException("Utility class");
    }

    public static Option findGame(Scanner scanner) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");

        try {
            final var gameNumber = scanner.nextInt();

            System.out.println("Your choice: " + gameNumber);

            return Option.valueOf(gameNumber);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unknown game.");

            return Option.UNRECOGNIZED;
        } catch (InputMismatchException e) {
            System.out.println("The game number must be an integer.");

            return Option.UNRECOGNIZED;
        }
    }
}
