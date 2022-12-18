package hexlet.code.games;

import java.util.List;
import java.util.Scanner;

public final class EvenGame extends Engine {
    private static final String YES = "yes";
    private static final String NO = "no";

    public EvenGame(String userName, Scanner scanner) {
        super(userName, scanner);
    }

    @Override
    protected String createQuestion() {
        final var number = getNewNumber(MIN_NUMBER, MAX_NUMBER);

        setAnswer(calcAnswer(number));

        return number.toString();
    }

    @Override
    protected void showDescription() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    protected boolean isRightAnswer(String userAnswer) {
        final var answerOptions = List.of(YES, NO);

        if (!answerOptions.contains(userAnswer)) {
            return false;
        }

        return getAnswer().equals(userAnswer);
    }


    private String calcAnswer(int number) {
        final var isEven = number % 2 == 0;

        return isEven ? YES : NO;
    }
}
