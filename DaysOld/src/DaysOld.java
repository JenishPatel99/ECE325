import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.regex.*;
/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */
public class DaysOld {

    /**
     * Calculate how many days between today and the date, and them out
     * @param birthday      {@code String} The start date
     */
    public static void days(String birthday) {
        // TODO: Assignment 1 -- write your code here.
    	int counter = 0;
    	ArrayList<Integer> al = new ArrayList<Integer>(3);
    	Calendar now = Calendar.getInstance();
    	Calendar birth = Calendar.getInstance();
    	String pattern = "[0-9]+";
    	Pattern p = Pattern.compile(pattern);
    	Matcher m = p.matcher(birthday);
    	
    	while (m.find()) {
    		int num = Integer.parseInt(birthday.substring(m.start(), m.end()));
    		al.add(num);
    	}
    	
    	birth.set(al.get(0), al.get(1)-1, al.get(2));
    	
    	if (!now.after(birth)) {
    		System.out.println("This is a wrong birthday");
    	} else {
    		while (now.get(Calendar.YEAR) != birth.get(Calendar.YEAR)
        			|| now.get(Calendar.MONTH) != birth.get(Calendar.MONTH)
        			|| now.get(Calendar.DAY_OF_YEAR) != birth.get(Calendar.DAY_OF_YEAR)) {
        		birth.add(Calendar.DAY_OF_YEAR, 1);

        		counter += 1;
        	}
    		System.out.println(counter);
    	}
    
    	

    } // public static void days(String birthday)

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        //days("2000-1-1");
        //days("3000-1-1");           // This is a wrong birthday
        //Add your birthday
        days("2020/9/17");
    }

}
