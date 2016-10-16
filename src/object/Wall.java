package object;

import gameState.SingleGame;

import java.awt.Graphics2D;
import java.util.Random;

public class Wall {
	int x1 = 350;
	int y1 = 50;
	int w1 = 10;
	int h1 = 50;
	
	int birdR = 10;
	
	
	public void init() {
		x1 = (int) (350+Math.random()*(600-350));
		y1 = (int) (Math.random()*200);
	}
	public void update() {
		x1--;
		collusion();
		if(x1 == 0) init();
	}
	public void darw(Graphics2D g) {
		g.fillRect(x1, y1, w1, h1);
	}

	
	public void collusion(){
		if(	   Bird.x + birdR >= x1 
			&& Bird.x 		  <= x1+w1
			&& Bird.y + birdR >= y1 
			&& Bird.y + birdR <= y1+h1){
			SingleGame.dead = true;
		}
	}
	
	
	
	
	
	
	
}
