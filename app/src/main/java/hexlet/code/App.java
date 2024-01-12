package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("""
				Please enter the game number and press Enter.
				1 - Greet
				2 - Even
				3 - Calc
				4 - GCD
				0 - Exit
				Your choice: """);
		String choice = reader.readLine();
		int game = Integer.parseInt(choice);
		if (game == 1) {
			Cli.startGame();
		} else if (game == 2) {
			Even.startGame();
		} else if (game == 3) {
			Calc.startGame();
		} else if (game == 4) {
			GCD.startGame();
		}
	}
}
