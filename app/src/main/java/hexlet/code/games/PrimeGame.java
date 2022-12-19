package hexlet.code.games;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public final class PrimeGame extends Engine {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String YES = "yes";
    private static final String NO = "no";

    public PrimeGame(String userName, Scanner scanner) {
        super(userName, scanner);
    }

    @Override
    protected String createQuestion() {
        final var number = getNewNumber(MIN_NUMBER, MAX_NUMBER);

        setAnswer(calcAnswer(number));

        return String.valueOf(number);
    }

    @Override
    protected String getDescription() {
        return DESCRIPTION;
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
        final BigInteger bigInteger = BigInteger.valueOf(number);
        final boolean isPrime = bigInteger.isProbablePrime((int) Math.log(number));

        return isPrime ? YES : NO;
    }
}
