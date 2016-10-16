package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	private BufferedImage under;
	private int underX1, underX2,underX3, underX4;
	
	
	public void init() throws IOException {
	under = ImageIO.read(getClass().getResourceAsStream("/imgs/cunder.png"));
	
	underX1 = 0;
	underX2 = 153;
	underX3 = 306;
	underX4 = 459;
	
	}

	public void update() {
		if(underX1 == -153) underX1 = 0;
		if(underX2 == 0) underX2 = 153;
		if(underX3 == 153) underX3 = 306;
		if(underX4 == 306) underX4 = 459;
		
		underX1 --;
		underX2 --;
		underX3 --;
		underX4 --;
		

	}
	
	public void draw(Graphics2D g) {
		g.drawImage(under, underX1,151, null);
		g.drawImage(under, underX2,151, null);
		g.drawImage(under, underX3,151, null);
		g.drawImage(under, underX4,151, null);
		
	}
}
