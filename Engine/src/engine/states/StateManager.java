package engine.states;

import java.util.ArrayList;
import java.util.List;



public class StateManager {
	private int currentState = 0;
	public List<State>states = new ArrayList<State>();

	
	public void add(State state){
		states.add(state);
	}
	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
	
}
