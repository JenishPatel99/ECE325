package inheritance_implementation;

public class car extends vehicle implements print{
	private int numOfWindows;
	private int numOfSeats;
	
	car() {
		this.numOfSeats = 5;
		this.numOfWindows = 4;
	}
	
	car(String color, int model, int price, int horsepower, int numOfWindows, int numOfSeats) {
		super(color, model, price, horsepower);
		this.numOfSeats = numOfSeats;
		this.numOfWindows = numOfWindows;
	}
	
	void getNumOfSeats() {
		System.out.println("Car has " + this.numOfSeats + " seats");
	}
	
	void getNumOfWindows() {
		System.out.println("Car has " + this.numOfWindows + " Windows");
	}
	
	public void displayInfo() {
		System.out.println("\nVehicle is type Car");
		super.getPrice();
		super.getModel();
		super.getColor();
		super.getHorsepower();
		super.getStartState();
		this.getNumOfSeats();
		this.getNumOfWindows();
	}
}
