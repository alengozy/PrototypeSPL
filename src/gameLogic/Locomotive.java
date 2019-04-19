package gameLogic;

import java.util.*;

/**
 * This class implements the locomotive's behavior. Locomotive is the engine of
 * a train, the number of locomotives corresponds to the number of the trains on
 * the level.
 */
class Locomotive extends Car {

	/**
	 * Constructor that calls the superclass Car's constructor which then sets the
	 * given cell as the one that the locomotive is currently at.
	 */
	int gloIndex = 0;
	int curIndex;
	public Locomotive(Cell cell) {
		super(cell);
		curIndex = gloIndex;
		gloIndex++;
	}
	
	/**
	 * This method checks if this car is a locomotive. Always returns true.
	 */
	@Override
	public boolean IsLocomotive() {
	
		return true;
	}

}