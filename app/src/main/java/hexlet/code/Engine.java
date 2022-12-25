package hexlet.code;

import hexlet.code.games.QuestionAnswerPair;

import java.util.Scanner;

public final class Engine {
    public static void play(Scanner scanner, String userName,
                            String description, QuestionAnswerPair[] questionAnswerPairs) {
        System.out.println(description);

        for (var questionAnswerPair : questionAnswerPairs) {
            final var userAnswer = getUserAnswer(scanner, questionAnswerPair.question());

            if (!isRightAnswer(questionAnswerPair.answer(), userAnswer)) {
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

    private static boolean isRightAnswer(String answer, String userAnswer) {
        return answer.equals(userAnswer);
    }

    private static String getUserAnswer(Scanner scanner, String question) {
        System.out.print("Question: " + question + "\n" + "Your answer: ");

        return scanner.next();
    }
}
