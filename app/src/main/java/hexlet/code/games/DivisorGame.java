package hexlet.code.games;

import hexlet.code.Params;
import hexlet.code.Utils;

public final class DivisorGame {
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 99;

    public static Game[] create() {
        final var games = new Game[Params.NUMBER_OF_QUESTIONS];

        for (var i = 0; i < Params.NUMBER_OF_QUESTIONS; i++) {
            final var num1 = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
            final var num2 = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);

            games[i] = new Game(getQuestion(num1, num2), String.valueOf(getAnswer(num1, num2)));
        }

        return games;
    }

    private static String getQuestion(int num1, int num2) {
        return num1 + " " + num2;
    }

    private static int getAnswer(int num1, int num2) {
        var max = Math.max(num1, num2);
        var min = Math.min(num1, num2);

        while (min != 0) {
            var tmp = max % min;
            max = min;
            min = tmp;
        }

        return max;
    }
}
