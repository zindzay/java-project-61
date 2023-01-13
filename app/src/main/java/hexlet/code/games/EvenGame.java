package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Params;
import hexlet.code.Utils;

public final class EvenGame {
    public static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;

    public static void play() {
        Engine.play(DESCRIPTION, initialize());
    }

    private static QuestionAnswerPair[] initialize() {
        final var questionAnswerPair = new QuestionAnswerPair[Params.NUMBER_OF_QUESTIONS];

        for (var i = 0; i < Params.NUMBER_OF_QUESTIONS; i++) {
            final var question = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
            final var answer = isEven(question) ? "yes" : "no";

            questionAnswerPair[i] = new QuestionAnswerPair(String.valueOf(question), answer);
        }

        return questionAnswerPair;
    }

    private static boolean isEven(final int number) {
        return number % 2 == 0;
    }
}
