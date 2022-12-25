package hexlet.code.games;

import hexlet.code.Params;
import hexlet.code.Utils;

public final class ProgressionGame {
    public static final String DESCRIPTION = "What number is missing in the progression?";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;
    private static final int MIN_NUMBER_IN_PROGRESSION = 5;
    private static final int MAX_NUMBER_IN_PROGRESSION = 10;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 9;
    private static final String PLACEHOLDER = "..";

    public static QuestionAnswerPair[] create() {
        final var questionAnswerPair = new QuestionAnswerPair[Params.NUMBER_OF_QUESTIONS];

        for (var i = 0; i < Params.NUMBER_OF_QUESTIONS; i++) {
            final var progression = getProgression();

            final var answer = getAnswer(progression);
            final var question = getQuestion(progression, answer);

            questionAnswerPair[i] = new QuestionAnswerPair(question, String.valueOf(answer));
        }

        return questionAnswerPair;
    }

    private static String getQuestion(int[] progression, int answer) {
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

    private static int getAnswer(int[] progression) {
        final var firstProgressionIndex = 0;
        final var lastProgressionIndex = progression.length - 1;
        final var hidedNumber = Utils.getNewNumber(firstProgressionIndex, lastProgressionIndex);

        return progression[hidedNumber];
    }

    private static int[] getProgression() {
        final var startNumber = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
        final var numberInProgression = Utils.getNewNumber(MIN_NUMBER_IN_PROGRESSION, MAX_NUMBER_IN_PROGRESSION);
        final var step = Utils.getNewNumber(MIN_STEP, MAX_STEP);
        final var progression = new int[numberInProgression];

        var nextNumber = startNumber;

        for (var i = 0; i < numberInProgression; i++) {
            progression[i] = nextNumber;
            nextNumber += step;
        }

        return progression;
    }
}
