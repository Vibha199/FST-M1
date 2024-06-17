package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 9, 5, 1, 4, 3 };
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));

	}
	


	private static void ascendingSort(int[] data) {
		// TODO Auto-generated method stub
		int size = data.length, i;
        
        for (i = 1; i < size; i++) {
            int key = data[i];
            int j = i - 1;
            
            while (j >= 0 && key < data[j]) {
                data[j + 1] = data[j];
                --j;
            }
            data[j + 1] = key;
		
	}

	}
}