package f_java.abstraction.c;

public class AnimalDog extends Animal {
	// template attributes variables
	private String name;
	// private String color; // was taken out to father class: Animal
	private double age;
	public static boolean hasTail = true; // same for all instances, automatically set by default during object initiation
	
	// constructor for setting input
	public AnimalDog(String c, double w , String n, double a) { // to all attributes
		super(c, w); // inherits from parent class: Animal, and initiated here
		this.name = n;
		if (a > 0) { // using input validation & correction
		this.age = a;
		}
		else {
			this.age = 0;
		}
	}
	
	public AnimalDog(String c, double w, String n) { // construct to only n c w
		super(c, w); // inherits from parent class: Animal, and initiated here
		this.name = n;
	}
	
	// get-set methods can hold code & logics
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		if (age > 0) {
		this.age = age;
		}
		else {
			this.age = 0;
		}
	}
	
	// more methods
	public void printAge() {
		System.out.println("my dog age is: " + age);
	};
	
	public void whoAmI() { // can override or extend the parent method
		super.whoAmI(); // parent method prints: "I'm an animal" (if you'll drop this part it will be over-written
		System.out.println("Animal type: dog");
	}
	
	public void printInfo() { // a method that prints all values of an instance-object with the inherit methods from parent class: Animal
		System.out.println("Dog instance = dog name: " + getName() + " | color: " + getColor() +  " | weight: " + getWeight() + " | age: " + getAge() + " years old | tail: " + AnimalDog.hasTail + "\n");
	}
	
	// future age + 5year
	public double futureAge(double year) { // a method that prints a value of age + int given
		return (getAge() + year);
	}
}
