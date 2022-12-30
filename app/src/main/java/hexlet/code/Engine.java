package hexlet.code;

import hexlet.code.games.QuestionAnswerPair;

import java.util.Scanner;

public final class Engine {
    public static void play(Scanner scanner, String description, QuestionAnswerPair[] questionAnswerPairs) {
        final var userName = Cli.findUserName(scanner);

        System.out.println(description);

        for (var questionAnswerPair : questionAnswerPairs) {
            final var question = questionAnswerPair.question();
            final var answer = questionAnswerPair.answer();

            System.out.print("Question: " + question + "\n" + "Your answer: ");
            final var userAnswer = scanner.next();

            if (!answer.equals(userAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was "
                        + "'" + questionAnswerPair.answer() + "'.\n"
                        + "Let's try again, " + userName + "!"
                );

                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
