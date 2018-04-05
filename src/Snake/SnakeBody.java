package Snake;

import java.util.Arrays;

public class SnakeBody {
	private String[] SnakeBody;
	private int head;
	private Boolean isDead;
	public int length;
	
	public SnakeBody(String[][] SnakeArena) {
		int spawnY = SnakeArena.length/2;
		int spawnX = SnakeArena[0].length/2;
		
		isDead = false;
		SnakeBody = new String[1];
		SnakeBody[0] = Integer.toString(spawnY) + ":" + Integer.toString(spawnX);
		head = 0;
		length = 1;
	}
	
	public void moveUp() {
		String oldHead[] = SnakeBody[head].split(":");
		String newHead = Integer.toString(Integer.parseInt(oldHead[0]) + 1) + ":" + oldHead[1];
		
		if(SelfCollision()) {
			Killed();
		}

		head++;
		if(head == length) {
			head = 0;
		}
		SnakeBody[head] = newHead;
	}
	
	public void moveDown() {
		String oldHead[] = SnakeBody[head].split(":");
		String newHead = Integer.toString(Integer.parseInt(oldHead[0]) - 1) + ":" + oldHead[1];
		
		if(SelfCollision()) {
			Killed();
		}

		head++;
		if(head == length) {
			head = 0;
		}
		SnakeBody[head] = newHead;
	}
	
	public void moveLeft() {
		String oldHead[] = SnakeBody[head].split(":");
		String newHead = oldHead[0] + ":" + Integer.toString(Integer.parseInt(oldHead[1]) - 1); 

		if(SelfCollision()) {
			Killed();
		}

		head++;
		if(head == length) {
			head = 0;
		}
		SnakeBody[head] = newHead;
	}
	
	public void moveRight() {
		String oldHead[] = SnakeBody[head].split(":");
		String newHead = oldHead[0] + ":" + Integer.toString(Integer.parseInt(oldHead[1]) + 1); 

		if(SelfCollision()) {
			Killed();
		}

		head++;
		if(head == length) {
			head = 0;
		}
		SnakeBody[head] = newHead;
	}
	
	public void grow() {
		String[] shedSnakeBody = new String[length];
		System.arraycopy(SnakeBody, 0, shedSnakeBody, 0, length);
		this.SnakeBody = new String[length + 1];
		
		for(int i = 0; i < length; i++) {
			head++;
			if(head == length) {
				head = 0;
			}
			
			this.SnakeBody[i] = shedSnakeBody[head];
		}
		head = length - 1;
		length++;
	}
	
	private Boolean SelfCollision() {
		if(Arrays.asList(SnakeBody).contains(head)) {
			return true;
		}
		return false;
	}
	
	public void Killed() {
		this.isDead = true;
	}
	
	public Boolean isDead() {
		return isDead;
	}
	
	public String[] getSnakeBody() {
		return this.SnakeBody;
	}
	
	public String getSnakeHead() {
		return this.SnakeBody[head];
	}
}
