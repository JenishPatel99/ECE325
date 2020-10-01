package arrays_and_debugging;
/**
 * Lab 1: Java Basics, Merge Sort and Maven <br />
 * The {@code MergeSort} class
 * @author <Jenish Patel>
 * @version <1.0>
 */
public class MergeSort {

    /**
     * Merges two arrays into a third array, in a way that the arrangement
     * into the third array is in the ascending order
     * @param left left array
     * @param right right array
     * @param numbers third array
     */
	public static void merge(int[] left,int[] right,int[] numbers) {
		int lengthLeft = left.length;
		int lengthRight = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		
		// Traverses two arrays and lowest element from both arrays is placed into third array
		while (i < lengthLeft && j < lengthRight) {
			if (left[i] <= right[j]) {
				numbers[k] = left[i];
				i += 1;
			} else {
				numbers[k] = right[j];
				j += 1;
			}
			k += 1;
		}
		
		// Traverses left array and places element into third array
		while (i < lengthLeft) {
			numbers[k] = left[i];
			i += 1;
			k += 1;
		}
		
		// Traverses right array and places element into third array
		while (j < lengthRight) {
			numbers[k] = right[j];
			j += 1;
			k += 1;
		}
	}
	
    /**
     * Breaks down array into subarrays recursively and then patches up the array
     * via calling merge function
     * @param numbers   {@code int[]} The integer array to be sorted
     * @return numbers the sorted array
     */
    public static int[] sort(int[] numbers) {
        int n = numbers.length; // Length of array
        
        // Base case
        if (n < 2) {
        	return numbers;
        }
        
        int mid = n/2;
        int leftSize = mid;
        int rightSize = n - mid;
        
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        
        // Copys elements from previous array into new array
        for (int i = 0; i < mid; i++) {
        	left[i] = numbers[i];
        }
        
        // Copys elements from previous array into new array
        for (int i = mid; i < n; i++) {
        	right[i - mid] = numbers[i];
        }
        
        sort(left);
        sort(right);
        
        merge(left, right, numbers);
        
        return numbers;
    }

    /**
     * Main entry: test the MergeSort
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 200);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        numbers = sort(numbers);

        for (int n: numbers)
            System.out.print(n + " ");
        System.out.println();
    }

}
