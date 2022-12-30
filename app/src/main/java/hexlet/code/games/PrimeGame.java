package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Params;
import hexlet.code.Utils;

import java.util.Scanner;
import java.util.stream.IntStream;

public final class PrimeGame {
    public static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;

    public static void play(Scanner scanner) {
        Engine.play(scanner, DESCRIPTION, initialize());
    }

    private static QuestionAnswerPair[] initialize() {
        final var questionAnswerPair = new QuestionAnswerPair[Params.NUMBER_OF_QUESTIONS];

        for (var i = 0; i < Params.NUMBER_OF_QUESTIONS; i++) {
            final var question = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
            final var answer = isPrime(question) ? "yes" : "no";

            questionAnswerPair[i] = new QuestionAnswerPair(String.valueOf(question), answer);
        }

        return questionAnswerPair;
    }

    private static boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }
}
