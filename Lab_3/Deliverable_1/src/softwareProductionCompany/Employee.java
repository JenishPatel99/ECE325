package softwareProductionCompany;

public class Employee extends Person{
	
	private double baseSalary;
	
	public Employee(String name, double baseSalary) {
		super(name);
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary() {
		return this.baseSalary;
	}
	
	/*public void setBaseSalary(double newSalary) {
		this.baseSalary = newSalary;
	}*/
}
