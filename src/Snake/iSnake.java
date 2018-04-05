package Snake;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iSnake {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the dimensions of the snake arena");
			int height = 0;
			int width = 0;
			
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
			SnakeArena snakeArena = new SnakeArena(height, width);
			snakeArena.Print();
			
			while(true) {
				
			}
			
		} catch (IOException ex) {
			System.out.print(ex.toString());
		}
	}
}
