package gameLogic;

/**
 * This class is a car that carries passengers.
 */
class PassengerCar extends Car {

	/**
	 * Constructor that assigns the car's current cell, and the color which will be
	 * compared with the stations' colors to drop passengers.
	 */
	public PassengerCar(Cell cell, Colors color) {
		super(cell);
		this.color = color;
		this.full = true;
	}

	/**
	 * This attribute stores the color of the car for it to drop the passengers if
	 * it matches the station¡¦s color.
	 */
	private Colors color;

	/**
	 * This attribute tells us if the train is empty or full of passengers.
	 */
	private boolean full;

	/**
	 * This method is a getter for the attribute full.
	 */
	public boolean isFull() {
		return full;
	}

	/**
	 * This method compares the colors of the station with the train's colors if the
	 * train is full. If the color matches, the full attribute is set to null and
	 * true is returned. If the color doesn't match the color of the station, false
	 * is returned. if the car is empty, the superclass' similarly method is called
	 * which switches on to the next attached car.
	 */
	@Override
	public boolean CurrentlyAtTheStation(Colors[] colors) {
		System.out.println(
				"\t>CurrentlyAtTheStation(Color[] colors): Tells the car that the passengers in the cars of these colors are allowed to leave the car.");
		if (full) {
			for (Colors c : Colors.values()) {
				if (c.toString().equals(this.color.toString())) {

					System.out.println(
							"\t<CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.");
					full = false;
					return true;
				}
			}
			System.out.println(
					"\t<CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.");
			return false;
		} else {
			System.out.println(
					"\t<CurrentlyAtTheStation(Color[] colors): True if people are leaving the train, false if not.");
			return super.CurrentlyAtTheStation(colors);
		}
	}
}
