package object;

import java.awt.Graphics2D;


public class Border {
	int donwRectX = 330;
	
	public Border() {}
	public void init() {
		donwRectX = 330;
	}
	public void update() {
		donwRectX--;
	}
	public void darw(Graphics2D g) {
		g.drawRect(donwRectX, 190, 20, 10);
	}

}
