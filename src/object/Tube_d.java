package object;

import gameState.Flappy;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tube_d {
	private int x,y;
	private int bodyX = 585;//set this
	private int headX = bodyX-2;
	
	private int bodyY = 130;//and this
	private int headY = bodyY-23;
	
	private int bodyY_up = bodyY - 130;
	private int headY_up = bodyY_up+52;

	private BufferedImage tube_head;
	private BufferedImage tube_body;
	private BufferedImage tube_head_up;

	public Tube_d(int x,int y) {
		this.x=x;
		this.y=y;
		bodyX = x;
		bodyY = y;
	}
	
	
	public void init() {

		bodyX = x ;
		headX = bodyX-2;
		
		bodyY = y;
		headY = bodyY-23;
		
		try {
			tube_head = ImageIO.read(getClass().getResourceAsStream("/imgs/tube_head.png"));
			tube_head_up = ImageIO.read(getClass().getResourceAsStream("/imgs/tube_head_up.png"));
			tube_body = ImageIO.read(getClass().getResourceAsStream("/imgs/tube_body.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void update() {
		bodyX--;
		headX = bodyX-2;
		collusion();
		re();
		
	}

	public void darw(Graphics2D g) {
		g.drawImage(tube_head_up, headX,headY_up, null);
		g.drawImage(tube_body, bodyX,bodyY_up , null);
		
		g.drawImage(tube_head, headX,headY, null);
		g.drawImage(tube_body, bodyX,bodyY , null);

	}

	public void collusion(){
		if(	   Flappybird.x	>= bodyX -18
			&& Flappybird.x	<= bodyX + 35
			&& Flappybird.y	>= headY - 13
			||
			   Flappybird.x	>= bodyX -18
			&& Flappybird.x	<= bodyX + 35
			&& Flappybird.y	<= headY_up +20
			)
			{
			System.out.println("dead");
			Flappy.dead = true;
		}
	}
	
	public void re() {
		if(x == 0)	init();
	}
}
