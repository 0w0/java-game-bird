package main;

import gameState.GameStateManager;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;


public class GamePanel extends JPanel 
	implements Runnable, KeyListener{

	//dimensions
	public static final int WIDTH = 350;
	public static final int HEIGHT = 200;
	public static final int SCALE = 2;
	
	//game thread
	private Thread thread;
	private boolean running;
	private long TargetTime = 1000 / FPS;
	public static int FPS = 65;
	
	//image
	private BufferedImage image;
	private Graphics2D g;
	
	//game state manager
	private GameStateManager gsm;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE,
				HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init() {
		
		image = new BufferedImage(
					WIDTH, HEIGHT,
					BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		running = true;
		
		gsm = new GameStateManager();
	}
	
	public void run() {
		
		init();
		long start;
		long elaspsed;
		long wait;
		
		//game loop
		while(running) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elaspsed = System.nanoTime() - start;
			
			wait = TargetTime - elaspsed / 100000;
			if(wait < 0 ) wait = 5;
			
			try {
				Thread.sleep(wait);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	private void update() {
		gsm.update();
	}
	private void draw() {
		gsm.draw(g);
	}
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0,
				WIDTH*SCALE,HEIGHT*SCALE, 
				null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
	}
}
