package softwareProductionCompany;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Date temp = new Date(2020, 10, 15);
		Person tom = new HwEngineer("tom", 3000, "Atlas");
		Customer frank = new Customer("frank", 100000);
		ProjManager sam = new ProjManager("tom", 6000, "Atlas", temp);
		
		System.out.println(sam.PrintInfo());
		sam.RaiseSalary();
		System.out.println(sam.PrintInfo());
		

	}

}
