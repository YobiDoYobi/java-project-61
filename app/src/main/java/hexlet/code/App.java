package hexlet.code;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("""
				Please enter the game number and press Enter.
				1 - Greet
				2 - Even
				0 - Exit""");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inpeutString = reader.readLine();
        int game = Integer.parseInt(inpeutString);
        System.out.println("Your choice: " + game + "\n");
        if (game == 1) {
            Cli.startGame();
        } else if (game == 2) {
            Even.startGame();
        }
    }
}
