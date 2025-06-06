package Piemeri;

public class Super {
	class Person {
	    String name;
	    Person(String name) {
	        this.name = name;
	    }
	}

	class Student extends Person {
	    int grade;
	    Student(String name, int grade) {
	        super(name);
	        this.grade = grade;
	    }
	}
}
