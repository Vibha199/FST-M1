package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> colors = new HashMap<Integer, String>();
		colors.put(1, "Red");
        colors.put(2, "Green");
        colors.put(3, "Blue");
        colors.put(4, "White");
        colors.put(5, "Black");
     // Print the Map
        System.out.println("The Original map: " + colors);
     // Remove one colour
        colors.remove(4);
        // Map after removing a colour
        System.out.println("After removing White: " + colors);
     // Check if green exists
        if(colors.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }
        
        // Print the size of the Map
        System.out.println("Number of pairs in the Map is: " + colors.size());
	}

}