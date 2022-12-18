package hexlet.code;

import hexlet.code.game.GameFactory;
import hexlet.code.game.UnsupportedGameException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var gameType = Menu.findGame(scanner);

            switch (gameType) {
                case GREET -> Cli.findUserName(scanner);
                case EVEN -> {
                    var userName = Cli.findUserName(scanner);
                    GameFactory.create(gameType, userName, scanner).play();
                }
                default -> {
                    // Exit
                }
            }
        } catch (UnsupportedGameException e) {
            System.out.println("Wrong game number. Let's try again.");
        } catch (Exception e) {
            System.out.println("Error. Let's try again.");
        }

    }
}
