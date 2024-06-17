package activities;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list= new ArrayList<Integer>();
		Random indexgen=new Random();
		System.out.print("Enter integers ");
		
		while(scan.hasNextInt()) {
			list.add(scan.nextInt());
	}
		Integer nums[] = list.toArray(new Integer[0]);
		int index = indexgen.nextInt(nums.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + nums[index]);
 
        scan.close();
	
	}

}