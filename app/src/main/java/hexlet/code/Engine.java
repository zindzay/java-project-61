package hexlet.code;

import hexlet.code.games.QuestionAnswerPair;

import static hexlet.code.Params.WELCOME_MESSAGE;
import static hexlet.code.Utils.getScanner;

public final class Engine {
    public static void play(final String description, final QuestionAnswerPair[] questionAnswerPairs) {
        final var scanner = getScanner();
        System.out.print(WELCOME_MESSAGE);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(description);

        for (final var questionAnswerPair : questionAnswerPairs) {
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
