import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */
public class DaysOld {
	
	/**
	 * Extracts the year, month and day from given string and inserts to
	 * an ArrayList, in a manner that the first, second and third index, are
	 * the year, month and day respectively.
	 * 
	 * @param birthday {@code String} String that is needed to convert to desired form
	 * @return ArrayList object called date
	 */
	public static ArrayList<Integer> changeFormat(String birthday) {
		ArrayList<Integer> date = new ArrayList<Integer>(3);
		String pattern = "[0-9]+";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(birthday);
		
		// Converts a substring of consecutive characters between 0-9 into Integers
		while (m.find()) {
			int num = Integer.parseInt(birthday.substring(m.start(), m.end()));
			date.add(num);
		}

		return date;
	}

	/**
	 * Calculate how many days between today and the date, and them out
	 * 
	 * @param birthday {@code String} The start date
	 */
	public static void days(String birthday) {
		int counter = 0;
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		// changes string format into ArrayList
		ArrayList<Integer> date = changeFormat(birthday);

		birth.set(date.get(0), date.get(1) - 1, date.get(2)); // Month is 0-indexed
		
		// If the birth date is in the future relative to today, then error message is conveyed
		if (!now.after(birth)) {
			System.out.println("This is a wrong birthday");
		} else {
			// loops until the birth date is not equal to today's date and the birth date is
			// incremented by a value of 1, which shows the days from birth
			while (now.get(Calendar.YEAR) != birth.get(Calendar.YEAR)
					|| now.get(Calendar.MONTH) != birth.get(Calendar.MONTH)
					|| now.get(Calendar.DAY_OF_YEAR) != birth.get(Calendar.DAY_OF_YEAR)) {
				birth.add(Calendar.DAY_OF_YEAR, 1);
				counter += 1;
			}
			System.out.println(counter);
		}
	}

	/**
	 * Main entry
	 * 
	 * @param args {@code String[]} Command line arguments
	 */
	public static void main(String[] args) {
		days("2000-1-1");
		days("3000-1-1"); // This is a wrong birthday
		// Add your birthday
		days("1999/11/15");
	}

}
