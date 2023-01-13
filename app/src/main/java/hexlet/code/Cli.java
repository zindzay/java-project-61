package hexlet.code;

import static hexlet.code.Params.WELCOME_MESSAGE;
import static hexlet.code.Utils.getScanner;

public final class Cli {
    public static void greet() {
        final var scanner = getScanner();
        System.out.print(WELCOME_MESSAGE);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}
