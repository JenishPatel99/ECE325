package inheritance_implementation;

public class main {
	
	int a  = 10;
	
	static void dis() {
		int a = 89;
		System.out.println(a);
	}

	public static void main(String[] args) {
		// construct a car 
		car civic = new car();
		civic.setColor("red");
		civic.setHorsepower(160);
		civic.setStartState(true);
		civic.setModel(2018);
		civic.setPrice(26000);
		
		// construct a plane
		airplane airbus = new airplane();
		airbus.setColor("White");
		airbus.setPrice(1000000);
		airbus.setHorsepower(20000);
		airbus.setModel(2015);
		airbus.setStartState(true);
		airbus.setOrigin("France");
		airbus.setAirline("Lufthansa");
		airbus.setManufacturer("Airbus");
		airbus.journey("Paris (CDG)", "New York (JFK)");
		
		// construct a train
		train amtrak = new train(10000, "Passenger", "EMD", 10); 
		amtrak.setColor("Blue");
		amtrak.setPrice(500000);
		amtrak.setModel(2001);
		amtrak.setStartState(true);
		amtrak.addCars(2);
		amtrak.journey("Washington DC", "Boston");
		
		civic.displayInfo();
		airbus.displayInfo();
		amtrak.displayInfo();
		
		airplane boeing = new airplane();
		boeing.journey("Toronto", "New York (JFK)");
		
		train cn = new train(16000, "freight", "Diesel", 50);
		cn.journey("Calgary", "Jasper");
		
		route f = boeing;
		System.out.println("\nClass: " + f.getClass());
		f.printJourney();
		route d = cn;
		System.out.println("\nClass: " + d.getClass());
		d.printJourney();
		
		int a[][] = new int[3][];
		System.out.println(a instanceof Object);
		a[1] = new int[]{1,2,3};
		a[2] = new int[]{4,5};
		System.out.println(a[1][1]);
		dis();
		
		int x = 0;
		int y = 10;
		
		main mi = new main();
		
		try {
			int z = y/x;
		}
		//System.out.println("Cannot divide by 0");
		catch(Exception e){
			System.out.println("Error");
		}
	}
	
	

}
