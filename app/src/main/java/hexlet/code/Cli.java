package hexlet.code;

import java.util.Scanner;

public final class Cli {
    public static String findUserName(Scanner scanner) {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = scanner.hasNext() ? scanner.next() : "";
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
