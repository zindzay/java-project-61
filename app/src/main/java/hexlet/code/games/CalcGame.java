package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Params;
import hexlet.code.Utils;
import hexlet.code.exceptions.UnsupportedOperationException;

import java.util.Scanner;

public final class CalcGame {
    public static final String DESCRIPTION = "What is the result of the expression?";

    private static final String[] OPERATIONS = new String[]{"+", "-", "*"};
    private static final int OPERATIONS_MIN_INDEX = 0;
    private static final int OPERATIONS_MAX_INDEX = OPERATIONS.length - 1;
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
            final var operation = OPERATIONS[Utils.getNewNumber(OPERATIONS_MIN_INDEX, OPERATIONS_MAX_INDEX)];
            final var question = getQuestion(num1, num2, operation);
            final var answer = String.valueOf(getAnswer(num1, num2, operation));

            questionAnswerPair[i] = new QuestionAnswerPair(question, answer);
        }

        return questionAnswerPair;
    }

    private static String getQuestion(int num1, int num2, String operation) {
        return num1 + " " + operation + " " + num2;
    }

    private static int getAnswer(int num1, int num2, String operation) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new UnsupportedOperationException();
        };
    }
}
