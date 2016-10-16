package gameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import object.*;

public class SingleGame extends GameState {
	Bird bird = new Bird();
	Border border = new Border();
	Wall wall_1 = new Wall();
	Wall wall_2 = new Wall();
	Wall wall_3 = new Wall();
	Wall wall_4 = new Wall();
	
	Wall wall_5 = new Wall();
	Wall wall_6 = new Wall();
	Wall wall_7 = new Wall();
	Wall wall_8 = new Wall();
	
	Wall wall_9 = new Wall();
	Wall wall_0 = new Wall();

	public static final int WIDTH = 480;
	public static final int HEIGHT = 400;
	
	public static boolean dead;
	public static boolean borderON;
	
	int count;
	
	public SingleGame(GameStateManager gsm) {
		this.gsm = gsm;
	
		init();
	}
	
	public void init() {
		dead = false;
		count = 0;
		bird.init();
		border.init();
		
		wall_1.init();
		wall_2.init();
		wall_3.init();
		wall_4.init();
		
		wall_5.init();
		wall_6.init();
		wall_7.init();
		wall_8.init();
		
		wall_9.init();
		wall_0.init();
		


	}
	public void update() {
		if (dead == false){
			bird.update();
			border.update();
			count++;
			
			wall_1.update();
			wall_2.update();
			wall_3.update();
			wall_4.update();

			if(count>=1000){
				wall_5.update();
				wall_6.update();
				wall_7.update();
				wall_8.update();
			}	
			if(count>=5000){
				wall_9.update();
				wall_0.update();

			}	
	
		}
		
	}
	
	public void draw(Graphics2D g) {
		//clear screen
		g.setColor(Color.black);
		g.fillRect( 0, 0, WIDTH, HEIGHT);
		g.setColor(Color.white);
		//draw the obj
		bird.draw(g);
		border.darw(g);
		
		wall_1.darw(g);
		wall_2.darw(g);
		wall_3.darw(g);
		wall_4.darw(g);
		wall_5.darw(g);
		wall_6.darw(g);
		wall_7.darw(g);
		wall_8.darw(g);
		wall_9.darw(g);
		wall_0.darw(g);
		


		
		if (dead == true){
			g.drawString("You dead", 140, 90);
			g.drawString("Try again (Y/N)?", 140, 110);
		}
	}
	public void keyPressed(int k) {
		//key control
		bird.keyPressed(k);
		//Restart key
		if(k==KeyEvent.VK_R){
			restart();
		}
		
		if (dead == true){
			if(k==KeyEvent.VK_Y)retry();
			if(k==KeyEvent.VK_N)notry();
		}
	}
	public void keyReleased(int k) {
		bird.keyReleased(k);
	}
		
	public void restart(){
		gsm.setState(GameStateManager.GameSTATE);
	}
	
	public void retry(){
		gsm.setState(GameStateManager.GameSTATE);
	}
	
	public void notry(){
		gsm.setState(GameStateManager.MENUSTATE);
	}
}

