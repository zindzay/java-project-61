package hexlet.code.game;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class EvenGame implements Game {
    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;
    private static final String YES = "yes";
    private static final String NO = "no";

    private final String userName;
    private final Random random;
    private final Scanner scanner;

    public EvenGame(String userName, Scanner scanner) {
        this.userName = userName;
        this.scanner = scanner;
        this.random = new Random();
    }

    @Override
    public void play() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            var number = getNewNumber();
            var answer = getAnswer(number);

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");

            var userAnswer = scanner.hasNext() ? scanner.next() : "";

            if (!isRightAnswer(answer, userAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(.Correct answer was " + "'" + answer + "'.");
                System.out.println("Let's try again, " + userName + "!");

                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }

    private String getAnswer(int number) {
        var isEven = number % 2 == 0;

        return isEven ? YES : NO;
    }

    private boolean isRightAnswer(String answer, String userAnswer) {
        var answerOptions = List.of(YES, NO);

        if (!answerOptions.contains(userAnswer)) {
            return false;
        }

        return answer.equals(userAnswer);
    }

    private int getNewNumber() {
        return random.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
    }
}
