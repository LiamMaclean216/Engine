package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GameThread extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private Engine engine;
	private boolean running = false;
	private int fps = 0;
	private int ups = 0;
	public static boolean counter = false;
	private int width, height;
	public GameThread(Engine engine,int width, int height) {
		this.engine = engine;
		this.width = width;
		this.height = height;
		setFocusable(true);
	}
	
	public void run() {
		
	
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;

		requestFocus();
		while (running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;

			lastTime = now;
			if(delta >= 1){
				engine.update();
				updates++;
				delta--;

			}
			
			engine.render(fps);
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer+=1000;
				fps =  frames;
				ups = updates;
				updates = 0;
				frames = 0;
			}

		}	
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		
		repaint();
	}
	
	public void start(){
		running = true;
	}
	
	public void stop(){
		running = false;
	}
	
}
