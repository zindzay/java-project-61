package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private Cli() {
        throw new IllegalStateException("Utility class");
    }

    public static String findUserName(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.hasNext() ? scanner.next() : "";
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
