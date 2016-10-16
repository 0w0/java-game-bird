package gameState;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

	private int currentChoice = 0;
	private String[] options = {
		"Single game",
		"Flappy mode",
		"Help",
		"Quit"
	};
	
	private Color titleColor;
//	private Font titleFont;
//	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			titleColor = new Color(128,0,0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void init() {}
	public void update() {}
	public void draw(Graphics2D g) {
		
		g.setColor(Color.black);
		g.fillRect( 0, 0, 480, 400);
		g.setColor(Color.white);		
		
		g.setColor(titleColor);
		g.drawString("Bird - I can fly !!", 130, 60);

		//draw menu options
		for(int i=0;i<options.length;i++){
			if (i==currentChoice){
				g.setColor(Color.RED);
			}else{
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 130, 80+i*15);
		}
	}
	
	private void select() {
		if(currentChoice == 0){
			gsm.setState(GameStateManager.GameSTATE);
		}
		if(currentChoice == 1){
			gsm.setState(GameStateManager.FlappySTATE);
		}
		if(currentChoice == 2){
			gsm.setState(GameStateManager.HelpSTATE);
		}
		if(currentChoice == 3){
			System.exit(0);
		}
	}
	
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_ENTER || k==KeyEvent.VK_SPACE){
			select();
		}
		if(k==KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1){
				currentChoice = options.length - 1;
			}
		}
		if(k==KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}
}
