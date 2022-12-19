package hexlet.code.games;

import java.util.Scanner;

public final class ProgressionGame extends Engine {
    private static final int MIN_NUMBER_IN_PROGRESSION = 5;
    private static final int MAX_NUMBER_IN_PROGRESSION = 10;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 9;
    private static final String PLACEHOLDER = "..";

    public ProgressionGame(String userName, Scanner scanner) {
        super(userName, scanner);
    }

    @Override
    protected String createQuestion() {
        final var startNumber = getNewNumber(MIN_NUMBER, MAX_NUMBER);
        final var numberInProgression = getNewNumber(MIN_NUMBER_IN_PROGRESSION, MAX_NUMBER_IN_PROGRESSION);
        final var step = getNewNumber(MIN_STEP, MAX_STEP);

        final var progression = getProgression(startNumber, numberInProgression, step);
        final var firstProgressionIndex = 0;
        final var lastProgressionIndex = progression.length - 1;
        final var hidedNumber = getNewNumber(firstProgressionIndex, lastProgressionIndex);

        final var answer = progression[hidedNumber];

        setAnswer(String.valueOf(answer));

        return getQuestion(progression, answer);
    }

    @Override
    protected void showDescription() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    protected boolean isRightAnswer(String userAnswer) {
        return getAnswer().equals(userAnswer);
    }

    private String getQuestion(int[] progression, int answer) {
        final var sb = new StringBuilder();

        for (var number : progression) {
            if (number == answer) {
                sb.append(PLACEHOLDER).append(" ");
            } else {
                sb.append(number).append(" ");
            }
        }

        return sb.toString();
    }

    private int[] getProgression(int startNumber, int numberInProgression, int step) {
        final var progression = new int[numberInProgression];
        var nextNumber = startNumber;

        for (var i = 0; i < numberInProgression; i++) {
            progression[i] = nextNumber;
            nextNumber += step;
        }

        return progression;
    }
}
