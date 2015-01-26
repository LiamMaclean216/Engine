package engine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import engine.input.Keyboard;
import engine.input.Mouse;
import engine.states.State;
import engine.states.StateManager;


public class Engine extends Canvas{
	private static final long serialVersionUID = 1L;

	private JFrame window;
	private GameThread gameThread;
	private Keyboard keyboard;
	private Mouse mouse;
	private StateManager sm = new StateManager();
	private Thread thread;
	private int width , height;
	
	private boolean fpsCounter = false; 
	
	public Engine(int width, int height, String windowTitle) {
		this.width = width;
		this.height = height;
		
		window = new JFrame();
		window.setSize(width, height);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setLocationRelativeTo(null);
		window.setTitle(windowTitle);
		window.setVisible(true);
		
		gameThread = new GameThread(this,width,height);
		keyboard = new Keyboard();
		mouse = new Mouse();
		
		window.add(this);
		
		window.addKeyListener(keyboard);
		window.addMouseListener(mouse);
	}

	public void start() {
		thread = new Thread(gameThread);
		thread.start();
		gameThread.start();
	}

	public void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gameThread.stop();
	}

	public void addState(State state){
		sm.add(state);
	}

	public void render(int fps){
		
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0,0,width,height);
		if(GameThread.counter){
			g.drawString("" + fps,0,0);
			
		}
		for(State s : sm.states){
			if(s.getID()==sm.getCurrentState()){
				s.render(this, g);
			}
		}
		
		g.dispose();
		bs.show();
	}
	public void update(){
		for(State s : sm.states){
			if(s.getID()==sm.getCurrentState()){
				s.update(this, keyboard);

			}
		}
	}
	
	public void setFpsCounter(boolean a){
		fpsCounter = a;
	}
	
	public void setWindowTitle(String title) {
		window.setTitle(title);
	}

	public Keyboard getKeyboard() {	
		return keyboard;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public JFrame getWindow() {
		return window;
	}
}
