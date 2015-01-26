package engine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import engine.input.Keyboard;
import engine.states.State;

public class Test extends State{
	//Image image; 
	int x = 0,y = 0;
	public static void main(String args[]){
		Test test = new Test();
	}
	public Test(){
		//image = new Image("res/spritesheet.png");
		Engine engine = new Engine(800,600, "dgdfg");
		engine.start();
		engine.addState(this);
		
	}
	public void init() {
		
	}


	public void render(Engine engine, Graphics g) {
		//image.render(g,x,y);
		
	}

	
	public void update(Engine engine ,Keyboard keyboard) {
		if(keyboard.isKeyDown(KeyEvent.VK_W)){
			y--;
		}
		if(keyboard.isKeyDown(KeyEvent.VK_S)){
			y++;
		}
		if(keyboard.isKeyDown(KeyEvent.VK_A)){
			x--;
		}
		if(keyboard.isKeyDown(KeyEvent.VK_D)){
			x++;
		}
		engine.setFpsCounter(true);
	}


	public int getID() {
		
		return 0;
	}
	
}