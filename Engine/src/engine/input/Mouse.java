package engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
	
	private static int mouseX;
	private static int mouseY;
	private static int mouseB = -1;
	private static int mouseRotateWay = -1;
	
	private static boolean down = false;
	private static boolean up = false;

	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
	}

	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseRotateWay = e.getWheelRotation();
	}
	
	public static int getMouseWheel() {
		return mouseRotateWay;
	}
	
	public static boolean buttonClicked(int butt) {
		if(butt == getButton()) down = true;
		if(down == true && getButton() == -1) up = true;
		
		if(up && down) {
			down = false;
			up = false;
			return true;
		}
		
		return false;
	}
	
	public static int getButton() {
		return mouseB;
	}
	
	public int getX() {
		return mouseX;
	}
	
	public int getY() {
		return mouseY;
	}

}
