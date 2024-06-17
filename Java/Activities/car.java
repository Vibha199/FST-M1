package activities;

public class Car {
	//Variables
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	//Constructor
	public Car() {
		tyres=4;
		doors=4;		
	}
	//Methods
	public void displayCharacteristics() {
		System.out.println("Color of the car is:"+color);
		System.out.println("Transmission of the car is:"+transmission);
		System.out.println("Make of the car is:"+make);
		System.out.println("Tyres of the car are:"+tyres);
		System.out.println("Doors of the car are:"+doors);
	}
	public void accelarate() {
		System.out.println("Car is moving forward.");	
	}
	public void brake() {
		System.out.println("Car has stopped.");
	}
}