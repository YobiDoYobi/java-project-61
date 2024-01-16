package hexlet.code;

import java.io.IOException;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
        runGame();
    }

    private static void runGame() throws IOException {
        String menu = sc.nextLine();
        switch (menu) {
            case "0" -> System.out.println("Bye!");
            case "1" -> hexlet.code.games.Cli.startGame();
            case "2" -> hexlet.code.games.Even.startGame();
            case "3" -> hexlet.code.games.Calc.startGame();
            case "4" -> hexlet.code.games.GCD.startGame();
            case "5" -> hexlet.code.games.Progression.startGame();
            case "6" -> hexlet.code.games.Prime.startGame();
            default -> noGame(menu);
        }
    }

    private static void noGame(String game) throws IOException {
        System.out.print("There is no variant '" + game + "'! Please enter again: ");
        runGame();
    }
}
