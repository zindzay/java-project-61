package hexlet.code;

import hexlet.code.exceptions.UnsupportedGameException;
import hexlet.code.games.CalcGame;
import hexlet.code.games.DivisorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.menu.Option;

import java.util.Scanner;

public final class Game {
    public static void play(Scanner scanner, Option option, String userName) {
        switch (option) {
            case EVEN_GAME -> Engine.play(scanner, userName, EvenGame.DESCRIPTION, EvenGame.create());
            case CALC_GAME -> Engine.play(scanner, userName, CalcGame.DESCRIPTION, CalcGame.create());
            case DIVISOR_GAME -> Engine.play(scanner, userName, DivisorGame.DESCRIPTION, DivisorGame.create());
            case PROGRESSION -> Engine.play(scanner, userName, ProgressionGame.DESCRIPTION, ProgressionGame.create());
            case PRIME -> Engine.play(scanner, userName, PrimeGame.DESCRIPTION, PrimeGame.create());
            default -> throw new UnsupportedGameException();
        }
    }
}
