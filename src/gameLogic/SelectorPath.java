package gameLogic;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * This class is responsible for choosing the path out of the fork.
 */
class SelectorPath extends Path {

	/**
	 * Constructor that accepts the cells and exits and assigns them to the Selector
	 * Path.
	 * 
	 */
	public SelectorPath(Cell[] cells, Cell[] exits) {
		this.cells = cells;
		this.exits = exits;
		if (this.cells.length > 0 && this.exits.length > 0) {
			this.cells[0].SetLogic(new PathStart(this));
			for (Cell cell : exits) {
				cell.SetLogic(new PathEnd());
			}
		} else {
			throw new InvalidParameterException();
		}
		selectedIndex = 0;
	}

	/**
	 * This attribute stores the exits out of the fork.
	 */
	private Cell[] exits;

	/**
	 * This attribute stores the number that corresponds to the player selection
	 * based on which the trains will be directed out of the fork.
	 */

	private int selectedIndex;

	/**
	 * This method chooses the path out of the fork.
	 */
	public void SelectNextExit() {
		System.out.println("\t>>SelectNextExit(): Selects the next exit of the path.");
		selectedIndex = (1 + selectedIndex) % exits.length;
	}

	/**
	 * This method returns the next cell after the given cell keeping in mind that
	 * it's in the fork.
	 */

	@Override
	public Cell NextCell(Cell cell) {
		System.out.println("\t>NextCell(Cell cell): Asks Path for the cell after the given one.");
		int index = 0;
		for (Cell localCell : cells) {
			index++;
			if (localCell == cell)
				break;
		}
		System.out.println(
				"\t<NextCell(Cell cell): Passes the next cell.  (null if the passed cell was the last one in the path)");
		if (index < cells.length)
			return cells[index];
		if (index == cells.length)
			return exits[selectedIndex];
		return null;
	}

	/**
	 * This method returns one of the exits that corresponds to the integer
	 * parameter.
	 */

	public Cell GetEndByIndex(int index) {
		return exits[index % exits.length];
	}

	
	/**
     * This method returns an exit that corresponds to the given index.
     */
	@Override
	public Cell GetEnd() {
		return exits[selectedIndex];
	}

	/**
     * This method returns the PathEnd logic of the exit matched with the given integer index.
     */
	public PathEnd GetEndLogicByIndex(int index) {
		return (PathEnd) exits[index % exits.length].GetLogic();
	}
	/**
     * This method returns the PathEnd logic of selected exit.
     */
	@Override
	public PathEnd GetEndLogic() {
		return (PathEnd) exits[selectedIndex].GetLogic();
	}

}