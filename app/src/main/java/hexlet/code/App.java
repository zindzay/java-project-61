package hexlet.code;

import hexlet.code.exceptions.UnsupportedGameException;
import hexlet.code.menu.Menu;

public class App {
    public static void main(String[] args) {
        try {
            Menu.invoke();
        } catch (UnsupportedGameException e) {
            System.out.println("Wrong game number. Let's try again.");
        } catch (Exception e) {
            System.out.println("Error. Let's try again.");
        }
    }
}
