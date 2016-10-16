package gameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Help extends GameState{
	
	public Help() {
		
	}

	public Help(GameStateManager gsm) {
		this.gsm = gsm;
	}

	public void init() {}


	public void update() {}


	public void draw(Graphics2D g) {
		
		g.setColor(Color.black);
		g.fillRect( 0, 0, 480, 400);
		g.setColor(Color.white);	
		
		g.drawString("Just believe you can fly", 100, 80);
		g.drawString("Tip : press 'SPACE' !!", 100, 100);
		
	}


	public void keyPressed(int k) {
		if(k==KeyEvent.VK_SPACE)
			gsm.setState(GameStateManager.MENUSTATE);
		if(k==KeyEvent.VK_ENTER)
			gsm.setState(GameStateManager.MENUSTATE);
		
	}


	public void keyReleased(int k) {}

}
