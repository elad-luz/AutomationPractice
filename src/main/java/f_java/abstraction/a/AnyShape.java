package f_java.abstraction.a;

public abstract class AnyShape { // parent instance all children inherits from
/** Notes about ABSTRACT:
 ** inheritance is an "is-a" relationship: you do inheritance by having another class, extending your class
	we need this parent class as a base, to help define other classes by - they will inherit from it (but it is as a general class for which no object is needed),
	'abstract' tells us we will not be able to initiate the parent instance by itself (it is used only as part of child instance) !!!
	note: if instead of 'abstract' we'll put 'final', it will prevent any use of this class as an extension (final = not parent to other classes)
	also: protected variable -> gives precedence access priority to extended classes (?)

	a method like seen below, can also be abstract => meaning that the method will not be implemented here, it comes as a placeholder for implementation at child!
	each child which extends this class must poses a method like such which is implemented as needed.
	you can have an abstract class without any abstract method included within it, BUT -
	abstract methods can only reside within an abstract class (if you have abstract method, class must be abstract as well)
	*/
	// fields (private) - all the properties of object
	private String name;
	private String color;
	// constructor - initialize the properties
	public AnyShape(String name, String color) {
		this.name = name;
		this.color = color;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	/** other methods wrapping methods...*/
	// abstract methods in parent are not stand-alone, but tells us we must implement them in child with a given meaning
	// abstract methods in parent will never contain the implementation of method - it will only be implement the child class
	// if the parent class contains abstract methods, it must also be defined as an abstract (see top)
	// the abstract method inherited by all shapes (children), is actually the common denominator of each & everyone...
	/** Example how using dummy which is not abstract, it will be Override by classes in children - BUT -
	    this will work put would poses problems => what if you have no method with that name or have a typo in children method -
	    it would not be run down by Override & you will get the method from Parent!
	public double calcArea() {
		return 0
	} // => So we must use abstraction level to assist us maintain code with a common denominator!
	*/
	// area - value will be calculated per shape => abstract = must!
	public abstract double calcArea();
	// perimeter - value will not be set but rather calculated later on...
	public abstract double calcPerimeter();
	/** NOTE:
		if the ^ above methods, would not have been stated here -
		then it would not have been possible to ask an array of shapes to give us the sum of calc Area & Perimeter (as we see in main)
	 */	
	// end of class -------------
}
