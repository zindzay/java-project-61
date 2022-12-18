package hexlet.code;

import hexlet.code.game.Type;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Menu {
    private Menu() {
        throw new IllegalStateException("Utility class");
    }

    public static Type findGame(Scanner scanner) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");

        try {
            var gameNumber = scanner.nextInt();

            System.out.println("Your choice: " + gameNumber);

            return Type.valueOf(gameNumber);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unknown game.");

            return Type.UNRECOGNIZED;
        } catch (InputMismatchException e) {
            System.out.println("The game number must be an integer.");

            return Type.UNRECOGNIZED;
        }
    }
}
