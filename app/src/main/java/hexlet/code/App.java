package hexlet.code;

import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Calc;
import hexlet.code.games.Progression;
import hexlet.code.games.Even;

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
            case "1" -> Cli.startCli();
            case "2" -> Even.startGame();
            case "3" -> Calc.startGame();
            case "4" -> GCD.startGame();
            case "5" -> Progression.startGame();
            case "6" -> Prime.startGame();
            default -> noGame(menu);
        }
    }

    private static void noGame(String game) throws IOException {
        System.out.print("There is no variant '" + game + "'! Please enter again: ");
        runGame();
    }
}
