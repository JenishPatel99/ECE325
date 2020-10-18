package softwareProductionCompany;

public class Customer extends Person implements Printable {
	
	private double projPrice;
	
	public Customer(String name, double projPrice) {
		super(name);
		this.projPrice = projPrice;
	}
	
	public double getProjPrice() {
		return this.projPrice;
	}
	
	public String PrintInfo() {
		String disp = "Name of Customer: " + super.getName() + "\n" + 
			      "Project price: $" + this.getProjPrice() + "\n";
		return disp;
	}
}
