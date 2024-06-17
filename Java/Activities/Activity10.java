package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		// Adding element to HashSet
        hs.add("S");
        hs.add("W");
        hs.add("A");
        hs.add("G");
        hs.add("T");
        hs.add("I");
      //Print HashSet
        System.out.println("Original HashSet: " + hs);        
        //Print size of HashSet
        System.out.println("Size of HashSet: " + hs.size());
      //Remove element
        System.out.println("Removing A from HashSet: " + hs.remove("A"));
        //Remove element that is not present
        if(hs.remove("X")) {
        	System.out.println("X removed from the Set");
        } else {
        	System.out.println("X is not present in the Set");
        }
        
        //Search for element
        System.out.println("Checking if W is present: " + hs.contains("W"));
        //Print updated HashSet
        System.out.println("Updated HashSet: " + hs);
	}
	

}