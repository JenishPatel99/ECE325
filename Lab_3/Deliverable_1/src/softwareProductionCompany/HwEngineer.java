package softwareProductionCompany;

public class HwEngineer extends Employee implements SalaryRaisable {

	public HwEngineer(String name, double baseSalary, String projName) {
		super(name, baseSalary);
	}
	
	public double RaiseSalary() {
		return super.getBaseSalary() * (1.18);
	}
}
