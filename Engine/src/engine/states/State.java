package engine.states;

import java.awt.Graphics;

import engine.Engine;
import engine.input.Keyboard;

public abstract class State {
	
	public abstract void init();
	public abstract void render(Engine engine, Graphics g);
	public abstract void update(Engine engine, Keyboard keyboard);
	public abstract int getID();
}
