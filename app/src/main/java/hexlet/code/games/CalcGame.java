package hexlet.code.games;

import hexlet.code.Params;
import hexlet.code.Utils;
import hexlet.code.exceptions.UnsupportedOperationException;

public final class CalcGame {
    public static final String DESCRIPTION = "What is the result of the expression?";

    private static final String[] OPERATIONS = new String[]{"+", "-", "*"};
    private static final int OPERATIONS_MIN_INDEX = 0;
    private static final int OPERATIONS_MAX_INDEX = OPERATIONS.length - 1;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 99;

    public static QuestionAnswerPair[] create() {
        final var questionAnswerPair = new QuestionAnswerPair[Params.NUMBER_OF_QUESTIONS];

        for (var i = 0; i < Params.NUMBER_OF_QUESTIONS; i++) {
            final var num1 = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
            final var num2 = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
            final var operation = getOperation();

            questionAnswerPair[i] = new QuestionAnswerPair(getQuestion(num1, num2, operation), String.valueOf(getAnswer(num1, num2, operation)));
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

    private static String getOperation() {
        final var operationIndex = Utils.getNewNumber(OPERATIONS_MIN_INDEX, OPERATIONS_MAX_INDEX);

        return OPERATIONS[operationIndex];
    }
}
