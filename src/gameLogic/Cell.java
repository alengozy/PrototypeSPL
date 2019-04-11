package gameLogic;

import java.util.*;

/**
 * This class is responsible for the basic spacial units of the level, cells.
 */
class Cell {

	/**
	 * This attribute stores true if the cell is occupied by a car, false otherwise.
	 */
	private Boolean occupied;

	/**
	 * This attribute stores the logic which decides the next move for the car.
	 */
	private CellLogic logic;

	/**
	 * Default constructor
	 */
	public Cell() {
		occupied = false;
	}

	public boolean LogicRequest(Car car) {
		System.out.println(
				"\t>LogicRequest(Car car): Decides if the train can leave the current cell and advance to the next cell along the path.");
		if (logic != null) {
			Boolean messageBool = logic.LogicRequest(car);

			System.out.println("\t<LogicRequest(Car car): Permission to leave the station.");
			return messageBool;
		}
		System.out.println("\t<LogicRequest(Car car): Permission to leave the station.");
		return true;
	}

	/**
	 * This method returns the logic of the cell.
	 */
	public CellLogic GetLogic() {
		return logic;
	}

	/**
	 * This method sets the logic for the cell.
	 */
	public void SetLogic(CellLogic logic) {
		this.logic = logic;
	}

	/**
	 * This method returns the value depending on the occupied attribute.
	 */
	public boolean IsOccupied() {
		System.out.print("\t>IsOccupied(): Check if this cell is occupied\n");

		System.out.print("\t<IsOccupied(): Returns false if cell is not occupied\n");
		return occupied;
	}

	/**
	 * This method sets the occupied value of the cell.
	 */
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

}