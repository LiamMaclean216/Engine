package engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	boolean[] keys = new boolean[700];
	boolean[] rkeys = new boolean[keys.length];
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]= true;
		rkeys[e.getKeyCode()]= false;
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]= false;
		rkeys[e.getKeyCode()]= true;
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	public boolean isKeyDown(int e){
		
		return keys[e];
	}
	public boolean isKeyPressed(int e){
		if(keys[e] == true && rkeys[e] == false){
			return true;
		}
		return false;
	}

}
