package hexlet.code;

import hexlet.code.games.GameFactory;
import hexlet.code.games.exception.UnsupportedGameException;
import hexlet.code.menu.Menu;
import hexlet.code.menu.Option;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final var option = Menu.findGame(scanner);

            if (option == Option.UNRECOGNIZED) {
                return;
            }

            final var userName = Cli.findUserName(scanner);

            if (option == Option.GREET) {
                return;
            }

            GameFactory.create(option, userName, scanner).play();
        } catch (UnsupportedGameException e) {
            System.out.println("Wrong game number. Let's try again.");
        } catch (Exception e) {
            System.out.println("Error. Let's try again.");
        }
    }
}
