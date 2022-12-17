package hexlet.code;

import java.util.Scanner;

public class Cli {
    private Cli() {
        throw new IllegalStateException("Utility class");
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Brain Games!");
    }

    public static void findUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        scanner.close();
    }
}
