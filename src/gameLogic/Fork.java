package gameLogic;

import java.util.*;

/**
 * This class is responsible for directing the train along the different paths
 * that go out of the fork depending on the player¡¦s choice.
 */
class Fork extends Segment {
	/**
	 * Default constructor
	 */

	public Fork() {

	}

	/**
	 * Constructor that creates the fork and the respective paths.
	 */

	public Fork(String id) {
		super(id);
		cells = new Cell[17];
		int i = 0;
		LinkedList<Cell> temp = new LinkedList<Cell>();
		LinkedList<Cell> temp2 = new LinkedList<Cell>();
		for (; i < 2; i++) {
			cells[i] = new Cell();
			temp.add(cells[i]);
		}
		for (; i < 4; i++) {
			cells[i] = new Cell();
			temp2.add(cells[i]);
		}
		selectorPath = new SelectorPath(temp.toArray(new Cell[temp.size()]), temp2.toArray(new Cell[temp2.size()]));
		temp = new LinkedList<Cell>();
		temp2 = new LinkedList<Cell>();
		for (; i < 7; i++) {
			cells[i] = new Cell();
			temp.add(cells[i]);
		}
		for (; i < 10; i++) {
			cells[i] = new Cell();
			temp2.add(cells[i]);
		}
		path01 = new Path(temp.toArray(new Cell[temp.size()]));
		path02 = new Path(temp2.toArray(new Cell[temp2.size()]));
		selectorPath.GetEndLogicByIndex(0).Connect(path01.GetStart());
		selectorPath.GetEndLogicByIndex(1).Connect(path02.GetStart());
		end1 = path01.GetEndLogic();
		end2 = path02.GetEndLogic();
		path20 = path02;
		path10 = path01;
		for (; i < 17; i++) {
			cells[i] = new Cell();
		}
		// paths 20 and 02 are left out as they are not important for the planned
		// demonstrations.

	}

	/**
	 * This attribute stores the selectorPath for the Fork to let the player select
	 * the outgoing path.
	 */
	private SelectorPath selectorPath;

	/**
	 * This attribute stores one of the fork¡¦s exits.
	 */
	private Path path20;

	/**
	 * This attribute stores another exit.
	 */
	private Path path02;

	private PathEnd end2;

	/**
	 * This method returns true or false respectively if the cell out of the fork is
	 * occupied by a car or not
	 */
	public boolean IsEmpty() {
		System.out.println("\t>IsEmpty():  checks if all the cells of the segment are free.	");
		for (Cell cell : this.cells) {
			if (cell.IsOccupied()) {
				System.out.println("\t<IsEmpty(): true if all the cells in the segment are empty.");
				return false;
			}
		}
		System.out.println("\t<IsEmpty():true if all the cells in the segment are empty.");
		return true;
	}

	/**
	 * This method chooses the path for the train on the fork. The first cell of the
	 * path should be empty which is checked by this method. It is called by the
	 * controller which is controlled by the player.
	 */
	public void Select() {
		System.out.print(">>Select(): Selects a path at a fork.");
		if (IsEmpty()) {
			selectorPath.SelectNextExit();

		}
	}

	// Method purely for skeleton
	/**
	 * 
	 * 
	 * this method returns a cell where a locomotive should be placed for
	 * demonstraton
	 */
	public Cell GET_DEMO_CELL(int index) {
		index %= 3;
		if (index == 1)
			return cells[5];
		if (index == 2)
			return cells[8];
		return cells[0];
	}

}