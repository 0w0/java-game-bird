package object;

import gameState.SingleGame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class Bird {
	static int x = 20;
	static int y = 100;
	int dy;
	int birdSize = 10;
	
	NumberFormat nf = NumberFormat.getInstance();
	static public double dist = 0;
		
	boolean flying = false;

	
	
	
	public Bird() {}
	public void init() {
		x = 20;
		y = 100;
		dist = 0;
		nf.setMaximumFractionDigits(2);
	}
	public void update(){
		
		dist = dist+0.01;
		if(flying == false) y++;
		else y += dy;
		
		if (dist%5 == 0){
			main.GamePanel.FPS += 5;
		}
		
		
		//dead condition
		if (y==190 || y==0) SingleGame.dead = true;
	}
	public void draw(Graphics2D g) {
		g.drawString("distance: "+nf.format(dist), 240, 190);
		g.drawString("M", 336, 190);
		g.fillOval(x, y, birdSize, birdSize);
	}
	
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_SPACE) {
			dy --;
			flying = true;
		}
	}

	public void keyReleased(int k) {
		if(k==KeyEvent.VK_SPACE) {
			flying = false;
			dy = 0;
		}
	}
	

}
