/**
 * Lab 1: Java Basics, Merge Sort and Maven <br />
 * The {@code MergeSort} class
 * @author <Jenish Patel>
 */
public class MergeSort {

    // More methods can be added here
	public static void merge(int[] left,int[] right,int[] numbers) {
		int lengthLeft = left.length;
		int lengthRight = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		
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
		
		while (i < lengthLeft) {
			numbers[k] = left[i];
			i += 1;
			k += 1;
		}
		while (j < lengthRight) {
			numbers[k] = right[j];
			j += 1;
			k += 1;
		}
	}
	
    /**
     * The merge sort procedure
     * @param numbers   {@code int[]} The integer array to be sorted
     */
    public static int[] sort(int[] numbers) {
        int n = numbers.length; // Length of array
        
        if (n < 2) {
        	return numbers;
        }
        
        int mid = n/2;
        int leftSize = mid;
        int rightSize = n - mid;
        
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        
        for (int i = 0; i < mid; i++) {
        	left[i] = numbers[i];
        }
        
        for (int i = mid; i < n; i++) {
        	right[i - mid] = numbers[i];
        }
        
        sort(left);
        sort(right);
        
        merge(left, right, numbers);
        
        return numbers;
    }

    /**
     * Main entry: test the HeapSort
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
