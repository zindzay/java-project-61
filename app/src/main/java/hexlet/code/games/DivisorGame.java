package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Params;
import hexlet.code.Utils;

import java.util.Scanner;

public final class DivisorGame {
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 99;

    public static void play(Scanner scanner) {
        Engine.play(scanner, DESCRIPTION, initialize());
    }

    private static QuestionAnswerPair[] initialize() {
        final var questionAnswerPair = new QuestionAnswerPair[Params.NUMBER_OF_QUESTIONS];

        for (var i = 0; i < Params.NUMBER_OF_QUESTIONS; i++) {
            final var num1 = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
            final var num2 = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
            final var question = getQuestion(num1, num2);
            final var answer = String.valueOf(getAnswer(num1, num2));

            questionAnswerPair[i] = new QuestionAnswerPair(question, answer);
        }

        return questionAnswerPair;
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
