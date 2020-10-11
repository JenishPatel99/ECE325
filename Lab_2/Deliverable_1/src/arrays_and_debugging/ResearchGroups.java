package arrays_and_debugging;
import java.util.*;
/**
 * Lab 2: Debugging with an IDE and Prefix Tree) <br />
 * The {@code ResearchGroup} class uses a 2D array to store the names of group members
 */

public class ResearchGroups {
    /**
     * Search a person to check whether he/she is in the groups
     * @param groups    {@code String[]} The 2D array of groups to be searched
     * @param name      {@code String} name of the person
     */
    public static void searchMember(String[][] groups, String name) {
        // TODO: Lab 2 Part 1-1 -- search and print the results here
    	for (int i = 0; i < 9; i++) {
    		if (Arrays.asList(groups[i]).contains(name)) {
    			int groupNumber = i;
    			if (groups[i][0] == name) {
    				System.out.println(name + " is the leader in group " + groupNumber + ".");
    			} else {
    				System.out.print(name + " is in group " + groupNumber + ".");
    				System.out.println();
    			}
    		}
    	}
    }

    /**
     * Sort groups by number of members <br />
     * @param groups    (<code>String[][]</code>) The 2D array of groups to be sorted
     */
    public static void sortGroups(String[][] groups) {
    	HashMap<Integer, String[]> groupMap = new HashMap<>();
    	int[] unsorted = new int[9];
    			
    	for (int i = 0; i < 9; i++) {
    		int hash = (groups[i].length * 100) + i;
    		unsorted[i] = hash;
    		groupMap.put(hash, groups[i]);
    	}
    	
    	unsorted = MergeSort.sort(unsorted);
    	
    	for (int i : unsorted) {
    		System.out.println(Arrays.deepToString(groupMap.get(i)));
    	}
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        String[][] groups = { {"Bob", "Carol", "Eric", "Matt"},             // 0
                              {"Jim", "Lucy", "Terry", "Brenda", "Ben"},    // 1
                              {"Susan", "Brad", "Jim"},                     // 2
                              {"Sue", "Wendy", "Sam"},                      // 3
                              {"Kate", "Jack", "James", "Sydney"},          // 4
                              {"Mohammad", "Tim", "Kian"},                  // 5
                              {"Emma", "Carol"},                            // 6
                              {"Nick", "Osama", "Harry", "Ben"},            // 7
                              {"Mary", "John", "Ricky"} };                  // 8

        ResearchGroups.searchMember(groups, "Jim");
        ResearchGroups.searchMember(groups, "Lucy");
        ResearchGroups.searchMember(groups, "Bob");
        ResearchGroups.searchMember(groups, "Jim");
        ResearchGroups.searchMember(groups, "Kian");
        ResearchGroups.searchMember(groups, "Susan");
        ResearchGroups.searchMember(groups, "John Doe");
        System.out.println("\nSorted groups in order of smallest to biggest size of groups: ");
        ResearchGroups.sortGroups(groups);
    }

}
