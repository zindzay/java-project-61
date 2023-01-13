package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class Utils {

    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Scanner getScanner() {
        return SCANNER;
    }

    public static int getNewNumber(final int min, final int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
