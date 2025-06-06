package Piemeri;

public class BezSuper {
	class Vehicle {
	    void move() {
	        System.out.println("Moving");
	    }
	}

	class Car extends Vehicle {
	    void move() {
	        System.out.println("Driving");
	    }
	}
}
