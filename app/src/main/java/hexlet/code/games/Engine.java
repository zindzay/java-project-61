package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

abstract class Engine implements Game {
    private static final int NUMBER_OF_QUESTIONS = 3;
    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 99;

    private final String userName;
    private final Random random;
    private final Scanner scanner;

    private String answer = "UNRECOGNIZED";

    protected Engine(String userName, Scanner scanner) {
        this.userName = userName;
        this.scanner = scanner;
        this.random = new Random();
    }

    protected String getAnswer() {
        return answer;
    }

    protected void setAnswer(String answer) {
        this.answer = answer;
    }

    private String getUserAnswer(String question) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");

        return scanner.next();
    }

    protected abstract void showDescription();

    protected abstract String createQuestion();

    protected abstract boolean isRightAnswer(String userAnswer);

    protected Integer getNewNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    @Override
    public void play() {
        showDescription();

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            final var question = createQuestion();
            final var userAnswer = getUserAnswer(question);

            if (!isRightAnswer(userAnswer)) {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was " + "'" + getAnswer() + "'.");
                System.out.println("Let's try again, " + userName + "!");

                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
