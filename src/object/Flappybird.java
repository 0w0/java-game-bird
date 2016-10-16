package object;

import gameState.Flappy;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Flappybird {
	static int x = 20;
	static int y = 60;
	int dy;
	
	private BufferedImage bird;

		
	boolean flying = false;

	public Flappybird() {}
	public void init() {
		x = 20;
		y = 60;
		
		try {
			bird = ImageIO.read(getClass().getResourceAsStream("/imgs/bird.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}
	public void update(){

		if(flying == false) y++;
		else y += dy;
		

		//dead condition
		if (y==137 || y==0) Flappy.dead = true;
	}
	public void draw(Graphics2D g) {
		g.drawImage(bird, x,y, null);
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
