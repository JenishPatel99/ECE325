package softwareProductionCompany;
import java.util.Date;

public class ProjManager extends SwEngineer implements Printable, SalaryRaisable {

	private Date projDeadline;
	
	public ProjManager(String name, double baseSalary, String projName, Date projDeadline) {
		super(name, baseSalary, projName);
		this.projDeadline = projDeadline;
	}
	
	public Date getProjDeadline() {
		return this.projDeadline;
	}
	
	public double RaiseSalary() {
		//super.setBaseSalary(super.getBaseSalary() * 1.24);
		return super.getBaseSalary() * 1.24;
	}
	
	public String PrintInfo() {
		String disp = "Name of Project Manager: " + super.getName() + "\n" + 
				      "Project name: " + super.getProjName() + "\n" +
					  "Final Salary: $" + this.RaiseSalary() + "\n" +
				      "Project Deadline: " + this.getProjDeadline() + "\n";
		return disp;
	}
}
