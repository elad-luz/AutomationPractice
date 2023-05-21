package f_java.abstraction.c;

public abstract class Animal { // parent instance all children inherits from this one - but because it is abstract, you can't make a stand-alone object of it !
	// if instead of 'abstract' we'll put 'final', it will prevent any use of this class as an extension (final = not parent to other classes)
	// also see bellow: 'PROTECTED '!!!
	//                   ---------
/** Notes about ABSTRACT:
	we need this parent class as a base, to help define other classes by - they will inherit from it (but it is as a general class for which no object is needed),
	'abstract' tells us we will not be able to initiate the parent instance by itself (it is used only as part of child instance) !!!
	note: if instead of 'abstract' we'll put 'final', it will prevent any use of this class as an extension (final = not parent to other classes)
	also: protected variable -> gives precedence access priority to extended classes (?)

	a method (like: printAge below), can also be abstract => meaning that the method will not be implemented here, it comes as a placeholder for implementation at child!
	each child which extends this class must poses a method like such which is implemented as needed.
	you can have an abstract class without any abstract method included within it, BUT -
	abstract methods can only reside within an abstract class (if you have abstract method, class must be abstract as well)
	 */
	// template attributes variables
	protected String color; // PROTECTED gives precedence access priority to extended classes (?)
	protected double weight;
	// constructor for setting input
	// public Animal(){} // this is the default constructor (implemented behind the scene), if the following is not defined
		public Animal(String c, double w) {
		this.color = c;
		this.weight = w;
	}
	//  get-set methods can hold code & logics
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	// more methods
	public void whoAmI() { // a method that prints: "I'm an animal"
		System.out.println("I'm an animal");
	}
	
	public void printAnimalInfo() { // a method that prints all values of Animal
		System.out.println("Animal instance: color = " + getColor() +  " -&- weight = " + getWeight() + "\n");
	}
	public abstract void printAge(); // abstract method will never be implemented (and will always be part of an abstract class) => the implementation is at the child level!
}
