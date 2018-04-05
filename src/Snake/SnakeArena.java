package Snake;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeArena {
	
	private String[][] SnakeArena;
	private String Apple;
	private SnakeBody SnakeBody;
	private int height;
	private int width;
	private int totalScore;
	
	public SnakeArena(int height, int width) {
		this.SnakeArena = new String[height][width];
		this.SnakeBody = new SnakeBody(SnakeArena);
		this.height = height;
		this.width = width;
		this.totalScore = 0;
		GenerateApple();
	}
	
	private void GenerateApple() {
		Boolean invalid = true;
		while(invalid) {
			int randomY = ThreadLocalRandom.current().nextInt(0, height);
			int randomX = ThreadLocalRandom.current().nextInt(0, width);
			SnakeArena[randomY][randomX] = "APPLE";
			Apple = Integer.toString(randomY) + ":" + Integer.toString(randomX);
			if (!Arrays.asList(this.SnakeBody.getSnakeBody()).contains(Apple)) {
				invalid = false;
			}
		}
	}
	
	public String getApple() {
		return this.Apple;
	}
	
	public void moveSnakeUp() {
		
	}

	public void moveSnakeDown() {
		
	}
	
	public void moveSnakeLeft() {
		
	}
	
	public void moveSnakeRight() {
		
	}
	
	public void Print() {
		System.out.println(Apple);
		for(int i = 0; i < height; i++) {
			String row = "";
			for(int j = 0; j < width; j++) {
				String gridUnit = Integer.toString(i) + ":" + Integer.toString(j);
				if (gridUnit.equals(getApple())) { 
					row += "o";
				} else if (this.SnakeBody.getSnakeHead().equals(gridUnit)) {
					row += "X";
				} else if (Arrays.asList(this.SnakeBody.getSnakeBody()).contains(gridUnit)) {
					row += "@";
				} else {
					row += " ";
				}
			}
			System.out.println(row);
		}
	}
}
