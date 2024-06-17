package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car Honda = new Car();
		Honda.make= 2014;
		Honda.color= "Black";
		Honda.transmission= "Manual";
		//calling Methods of Car class
		Honda.displayCharacteristics();
		Honda.accelarate();
		Honda.brake();
		
	}

}