package inheritance_implementation;

public class train extends vehicle implements print, route {
	private int numOfCars;
	private String typeOfTrain;
	private String typeOfLoco;
	public String origin;
	public String destination; 
	
	train() {}
	
	train(int horsepower, String typeOfTrain, String typeOfLoco, int numOfCars) {
		super.setHorsepower(horsepower);
		this.typeOfTrain = typeOfTrain;
		this.typeOfLoco = typeOfLoco;
		this.numOfCars = numOfCars;
	}
	
	void getNumOfCars() {
		System.out.println("Train has " + this.numOfCars + " attached to it");
	}
	
	void addCars(int x) {
		this.numOfCars += x;
	}
	
	void getTypeOfTrain() {
		System.out.println("Train is a " + this.typeOfTrain);
	}
	
	void getTypeOfLoco() {
		System.out.println("Loco of train is " + this.typeOfLoco );
	}
	
	void setTypeOfLoco(String typeOfLoco) {
		this.typeOfLoco = typeOfLoco;
	}
	
	public void journey(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	public void printJourney() {
		System.out.println(this.origin + " -> " + this.destination);
	}
	
	public void displayInfo() {
		System.out.println("\nVehicle is type Train");
		super.getPrice();
		super.getModel();
		super.getColor();
		super.getHorsepower();
		super.getStartState();
		this.getNumOfCars();
		this.getTypeOfTrain();
		this.getTypeOfLoco();
		printJourney();
	}
}
