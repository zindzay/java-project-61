package hexlet.code;

import hexlet.code.games.Game;

import java.util.Scanner;

public final class Engine {
    public static void play(Scanner scanner, String userName, String description, Game[] games) {
        System.out.println(description);

        for (var game : games) {
            final var userAnswer = getUserAnswer(scanner, game.question());

            if (!isRightAnswer(game.answer(), userAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was "
                        + "'" + game.answer() + "'.\n"
                        + "Let's try again, " + userName + "!"
                );

                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }

    private static boolean isRightAnswer(String answer, String userAnswer) {
        return answer.equals(userAnswer);
    }

    private static String getUserAnswer(Scanner scanner, String question) {
        System.out.print("Question: " + question + "\n" + "Your answer: ");

        return scanner.next();
    }
}
