package hexlet.code.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Menu {
    public static Option findGame(Scanner scanner) {
        System.out.println("Please enter the game number and press Enter.\n" + Option.toStringOptions());

        try {
            final var gameNumber = scanner.nextInt();
            System.out.println("Your choice: " + gameNumber);
            return Option.valueOf(gameNumber);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unknown option.");
            return Option.UNRECOGNIZED;
        } catch (InputMismatchException e) {
            System.out.println("The option must be an integer.");
            return Option.UNRECOGNIZED;
        }
    }
}
