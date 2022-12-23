package hexlet.code.games;

import hexlet.code.Params;
import hexlet.code.Utils;

import java.math.BigInteger;

public final class PrimeGame {
    public static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

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
        final BigInteger bigInteger = BigInteger.valueOf(number);
        final boolean isPrime = bigInteger.isProbablePrime((int) Math.log(number));

        return isPrime ? "yes" : "no";
    }
}
