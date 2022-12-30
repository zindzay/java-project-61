package hexlet.code;

import hexlet.code.exceptions.UnsupportedGameException;
import hexlet.code.menu.Menu;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Menu.playGame(scanner, Menu.findGame(scanner));
        } catch (UnsupportedGameException e) {
            System.out.println("Wrong game number. Let's try again.");
        } catch (Exception e) {
            System.out.println("Error. Let's try again.");
        }
    }
}
