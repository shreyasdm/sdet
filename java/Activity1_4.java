package JavaActivity4;

import java.util.Arrays;

	public class Activity1_4 {
	    static void ascendingSort(int array[]) {
	        int size = array.length, i;
	        
	        for (i = 1; i < size; i++) {
	            int key = array[i];
	            int j = i - 1;
	            
	            while (j >= 0 && key < array[j]) {
	                array[j + 1] = array[j];
	                --j;
	            }
	            array[j + 1] = key;
	        }
	    }
	    
	    public static void main(String args[]) {
	        int[] data = { 4, 3, 2, 10, 12, 1, 5,6 };
	        System.out.println("Before Sorting: \n" + Arrays.toString(data));
	        ascendingSort(data);
	        System.out.println("After Sorting in Ascending Order: ");
	        System.out.println(Arrays.toString(data));
	    }
	}

