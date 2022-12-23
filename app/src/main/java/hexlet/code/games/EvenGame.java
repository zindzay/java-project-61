package hexlet.code.games;

import hexlet.code.Params;
import hexlet.code.Utils;

public final class EvenGame {
    public static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;

    public static Game[] create() {
        final var games = new Game[Params.NUMBER_OF_QUESTIONS];

        for (var i = 0; i < Params.NUMBER_OF_QUESTIONS; i++) {
            final var question = getQuestion();
            final var answer = getAnswer(question);

            games[i] = new Game(String.valueOf(question), answer);
        }

        return games;
    }

    private static int getQuestion() {
        return Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
    }

    private static String getAnswer(int number) {
        final var isEven = number % 2 == 0;

        return isEven ? "yes" : "no";
    }
}
