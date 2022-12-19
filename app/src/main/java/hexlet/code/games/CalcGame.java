package hexlet.code.games;

import hexlet.code.games.exception.UnsupportedOperationException;

import java.util.List;
import java.util.Scanner;

public final class CalcGame extends Engine {
    private static final List<String> OPERATIONS = List.of("+", "-", "*");
    private static final int OPERATIONS_MIN_INDEX = 0;
    private static final int OPERATIONS_MAX_INDEX = OPERATIONS.size() - 1;

    public CalcGame(String userName, Scanner scanner) {
        super(userName, scanner);
    }

    @Override
    protected String createQuestion() {
        final var num1 = getNewNumber(MIN_NUMBER, MAX_NUMBER);
        final var num2 = getNewNumber(MIN_NUMBER, MAX_NUMBER);
        final var operationIndex = getNewNumber(OPERATIONS_MIN_INDEX, OPERATIONS_MAX_INDEX);
        final var operation = OPERATIONS.get(operationIndex);

        final var question = num1 + " " + operation + " " + num2;

        setAnswer(calcAnswer(num1, num2, operation));

        return question;
    }

    @Override
    protected void showDescription() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    protected boolean isRightAnswer(String userAnswer) {
        return getAnswer().equals(userAnswer);
    }

    private String calcAnswer(int num1, int num2, String operation) {
        return switch (operation) {
            case "+" -> String.valueOf(num1 + num2);
            case "-" -> String.valueOf(num1 - num2);
            case "*" -> String.valueOf(num1 * num2);
            default -> throw new UnsupportedOperationException();
        };
    }
}
