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
	private Boolean gameOver = false;
	
	public SnakeArena(int height, int width) {
		this.SnakeArena = new String[height][width];
		SnakeBody = new SnakeBody(SnakeArena);
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
			if (!Arrays.asList(SnakeBody.getSnakeBody()).contains(Apple)) {
				invalid = false;
			}
		}
	}
	
	public String getApple() {
		return this.Apple;
	}
	
	public void moveSnakeUp() {
		String newHead = SnakeBody.moveUp();
		if(SnakeBody.isDead() || wallCollision()) {
			System.out.println("GAME OVER - TOTAL SCORE: " + Integer.toString(totalScore));
			gameOver = true;
		} else if (Apple.equals(newHead)) {
			totalScore += 10;
			GenerateApple();
			SnakeBody.grow();
		} else {
			//System.out.print("moved up -> " + newHead);
		}
	}

	public void moveSnakeDown() {
		String newHead = SnakeBody.moveDown();
		if(SnakeBody.isDead() || wallCollision()) {
			System.out.println("GAME OVER - TOTAL SCORE: " + Integer.toString(totalScore));
			gameOver = true;
		} else if (Apple.equals(newHead)) {
			totalScore += 10;
			GenerateApple();
			SnakeBody.grow();
		} else {
			//System.out.print("moved down -> " + newHead);
		}
	}
	
	public void moveSnakeLeft() {
		String newHead = SnakeBody.moveLeft();
		if(SnakeBody.isDead() || wallCollision()) {
			System.out.println("GAME OVER - TOTAL SCORE: " + Integer.toString(totalScore));
			gameOver = true;
		} else if (Apple.equals(newHead)) {
			totalScore += 10;
			GenerateApple();
			SnakeBody.grow();
		} else {
			//System.out.print("moved left -> " + newHead);
		}
	}
	
	public void moveSnakeRight() {
		String newHead = SnakeBody.moveRight();
		if(SnakeBody.isDead() || wallCollision()) {
			System.out.println("GAME OVER - TOTAL SCORE: " + Integer.toString(totalScore));
			gameOver = true;
		} else if (Apple.equals(newHead)) {
			totalScore += 10;
			GenerateApple();
			SnakeBody.grow();
		} else {
			//System.out.print("moved right -> " + newHead);
		}
	}
	
	public Boolean wallCollision() {
		System.out.println(SnakeBody.getSnakeHead());
		if(SnakeBody.getSnakeHead().contains("-")) {
			return true;
		} else {
			
		}
		return false;
	}
	
	public Boolean isGameOver() {
		return gameOver;
	}
	
	public void Print() {
		for(int i = 0; i < height; i++) {
			String row = "";
			for(int j = 0; j < width; j++) {
				String gridUnit = Integer.toString(i) + ":" + Integer.toString(j);
				if (gridUnit.equals(getApple())) { 
					row += "o";
				} else if (SnakeBody.getSnakeHead().equals(gridUnit)) {
					row += "X";
				} else if (Arrays.asList(SnakeBody.getSnakeBody()).contains(gridUnit)) {
					row += "@";
				} else {
					row += "~";
				}
			}
			System.out.println(row);
		}
	}
}
