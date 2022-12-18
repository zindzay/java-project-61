package hexlet.code.games;

import java.util.Scanner;

public final class DivisorGame extends Engine {
    public DivisorGame(String userName, Scanner scanner) {
        super(userName, scanner);
    }

    @Override
    protected String createQuestion() {
        final var num1 = getNewNumber(MIN_NUMBER, MAX_NUMBER);
        final var num2 = getNewNumber(MIN_NUMBER, MAX_NUMBER);

        final var question = num1 + " " + num2;

        setAnswer(calcAnswer(num1, num2));

        return question;
    }

    @Override
    protected void showDescription() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    protected boolean isRightAnswer(String userAnswer) {
        return getAnswer().equals(userAnswer);
    }

    private String calcAnswer(int num1, int num2) {
        var max = Math.max(num1, num2);
        var min = Math.min(num1, num2);

        while (min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }

        return String.valueOf(max);
    }
}