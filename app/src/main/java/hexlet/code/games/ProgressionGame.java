package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Params;
import hexlet.code.Utils;

import java.util.Scanner;

public final class ProgressionGame {
    public static final String DESCRIPTION = "What number is missing in the progression?";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;
    private static final int MIN_NUMBER_IN_PROGRESSION = 5;
    private static final int MAX_NUMBER_IN_PROGRESSION = 10;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 9;
    private static final String PLACEHOLDER = "..";

    public static void play(Scanner scanner) {
        Engine.play(scanner, DESCRIPTION, initialize());
    }

    private static QuestionAnswerPair[] initialize() {
        final var questionAnswerPair = new QuestionAnswerPair[Params.NUMBER_OF_QUESTIONS];

        for (var i = 0; i < Params.NUMBER_OF_QUESTIONS; i++) {
            final var startNumber = Utils.getNewNumber(MIN_NUMBER, MAX_NUMBER);
            final var numberInProgression = Utils.getNewNumber(MIN_NUMBER_IN_PROGRESSION, MAX_NUMBER_IN_PROGRESSION);
            final var step = Utils.getNewNumber(MIN_STEP, MAX_STEP);

            questionAnswerPair[i] = createQuestionAnswerPair(startNumber, numberInProgression, step);
        }

        return questionAnswerPair;
    }

    private static QuestionAnswerPair createQuestionAnswerPair(int startNumber, int numberInProgression, int step) {
        final var progression = getProgression(startNumber, numberInProgression, step);

        final var hidedNumberIndex = Utils.getNewNumber(0, progression.length - 1);
        final var answer = progression[hidedNumberIndex];

        progression[hidedNumberIndex] = PLACEHOLDER;

        final var question = String.join(" ", progression);

        return new QuestionAnswerPair(question, answer);
    }

    private static String[] getProgression(int startNumber, int numberInProgression, int step) {
        final var progression = new String[numberInProgression];

        var nextNumber = startNumber;

        for (var i = 0; i < numberInProgression; i++) {
            progression[i] = String.valueOf(nextNumber);
            nextNumber += step;
        }

        return progression;
    }
}
