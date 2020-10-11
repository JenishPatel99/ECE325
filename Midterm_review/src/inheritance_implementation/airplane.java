package inheritance_implementation;

public class airplane extends vehicle implements print, route {
	private String airline;
	private String origin;
	private String manufacturer;
	public String source;
	public String destination; 
	
	airplane() {}
	
	airplane(String color, int model, int price, int horsepower, String airline, String origin, String manufacturer) {
		super(color, model, price, horsepower);
		this.airline = airline;
		this.origin = origin;
		this.manufacturer = manufacturer;
	}
	
	@Override
	public void setStartState(boolean fly) {
		super.start = fly;
	}
	
	@Override
	public void getStartState() {
		if (super.start == true) {
			System.out.println("plane is in flight");
		} else {
			System.out.println("plane is stationary");
		}
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	void getAirline() {
		System.out.println(this.airline);
	}
	
	void setAirline(String airline) {
		this.airline = airline;
	}
	
	void getOrigin() {
		System.out.println("Airplane is affiliated with " + this.origin);
	}
	
	void setOrigin(String origin) {
		this.origin = origin;
	}
	
	void getManufacturer() {
		System.out.println("Airplane manufactuered by " + this.manufacturer);
	}
	
	public void journey(String source, String destination) {
		this.source = source;
		this.destination = destination;
	}
	
	public void printJourney() {
		System.out.println(this.source + " -> " + this.destination);
	}
	
	public void displayInfo() {
		System.out.println("\nVehicle is type Plane");
		super.getPrice();
		super.getModel();
		super.getColor();
		super.getHorsepower();
		this.getManufacturer();
		this.getAirline();
		this.printJourney();
		getStartState();
	}
	
}
