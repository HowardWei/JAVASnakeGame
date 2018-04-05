package Snake;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iSnake {
	public static void main(String[] args) {
		SnakeArena SnakeGame;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the dimensions of the snake arena");
			int height = 0;
			int width = 0;
			String input = "";
			
			Boolean invalid = true;
			while(invalid) {
				System.out.print("Height: ");
				try {
					height = Integer.parseInt(br.readLine());
				} catch (NumberFormatException ex) {
					System.out.println("Invalid number format");
				}
				invalid = false;
			}
			invalid = true;
			while(invalid) {
				System.out.print("Width: ");
				try {
					width = Integer.parseInt(br.readLine());
				} catch (NumberFormatException ex) {
					System.out.println("Invalid number format");
				}
				invalid = false;
			}
			SnakeGame = new SnakeArena(height, width);
			SnakeGame.Print();
			while(!SnakeGame.isGameOver()) {
				try {
					input = br.readLine();
					if(input.equalsIgnoreCase("W")) {
						SnakeGame.moveSnakeUp();
					} else if (input.equalsIgnoreCase("A")) {
						SnakeGame.moveSnakeLeft();
					} else if (input.equalsIgnoreCase("S")) {
						SnakeGame.moveSnakeDown();
					} else if (input.equalsIgnoreCase("D")) {
						SnakeGame.moveSnakeRight();
					} else {
						throw new IllegalArgumentException("Not a valid movement command: try (W,A,S,D)");
					}
					SnakeGame.Print();
					System.out.println(SnakeGame.isGameOver());
				} catch (IllegalArgumentException ex) {
					System.out.println(ex.getMessage());
				}
			}
			
		} catch (IOException ex) {
			System.out.print(ex.toString());
		}
	}
}
