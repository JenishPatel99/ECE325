package inheritance_implementation;

public class vehicle {
	protected boolean start;
	private int price;
	private String color;
	private int model; 
	private int horsepower;
	
	vehicle() {
		this.color = "black";
		this.start = false;
	}
	
	vehicle(String color, int model, int price, int horsepower) {
		this.color = color;
		this.price = price;
		this.model = model;
		this.start = false;
		this.horsepower = horsepower;
	}
	
	public void getStartState() {
		if (this.start == true) {
			System.out.println("Vehicle is running");
		} else {
			System.out.println("Vehicle is not running");
		}
	}
	
	public void setStartState(boolean start) {
		this.start = start;
	}
	
	public void getColor() {
		System.out.println("Color: " + this.color);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setModel(int model) {
		this.model = model;
	}
	
	public void getModel() {
		System.out.println("Model year: "+ this.model);
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void getPrice() {
		System.out.println("Price: $" + this.price);
	}
	
	public void getHorsepower() {
		System.out.println("Horsepower: " + this.horsepower + " HP");
	}
	
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
}
