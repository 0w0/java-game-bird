package gameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;

import object.*;

public class Flappy extends GameState{
	Bg bg = new Bg();
	Tube tube_1 = new Tube(330, 120);
	Tube tube_2 = new Tube(500, 120);
	Tube tube_3 = new Tube(730, 120);
	
	Tube tube_u_1 = new Tube(415, 100);
	
	Tube tube_d_1 = new Tube(585, 130);
	
	
	Ground ground = new Ground();
	Flappybird bird = new Flappybird();

	
	public static boolean dead;
	public Flappy(GameStateManager gsm) {
		this.gsm = gsm;
		init();	
	}


	public void init() {

		
		try {
			bg.init();
			bird.init();
			tube_1.init();
			tube_2.init();
			tube_3.init();
			
			tube_u_1.init();
			tube_d_1.init();
			
			ground.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dead = false;
	}


	public void update() {
		if (dead == false){
			bg.update();
			bird.update();
			tube_1.update();
			tube_2.update();
			tube_3.update();
			
			tube_u_1.update();
			tube_d_1.update();
			ground.update();
		}
		
	}

	public void draw(Graphics2D g) {
		//clear screen
		g.setColor(Color.black);
		g.fillRect( 0, 0, 350, 200);
		g.setColor(Color.white);
		//draw the obj
		bg.draw(g);
		tube_1.darw(g);
		tube_2.darw(g);
		tube_3.darw(g);
		
		tube_u_1.darw(g);
		tube_d_1.darw(g);
		ground.draw(g);
		bird.draw(g);
		
		if (dead == false) {
	
		}
		
		else {
			g.drawString("You dead", 140, 70);
			g.drawString("Try again (Y/N)?", 140, 90);
		}

	}

	public void keyPressed(int k) {
		bird.keyPressed(k);
		
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
		gsm.setState(GameStateManager.FlappySTATE);
	}
	
	public void retry(){
		gsm.setState(GameStateManager.FlappySTATE);
	}
	
	public void notry(){
		gsm.setState(GameStateManager.MENUSTATE);
	}
}
