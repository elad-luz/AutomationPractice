package h_java.exercises.polymoCases1b;

public abstract class AnyShape { // parent instance all children inherits from
/** Notes about ABSTRACT:
	we need this parent class as a base, to help define other classes by - they will inherit from it (but it is as a general class for which no object is needed),
	'abstract' tells us we will not be able to initiate the parent instance by itself (it is used only as part of child instance) !!!
	note: if instead of 'abstract' we'll put 'final', it will prevent any use of this class as an extension (final = not parent to other classes)
	also: protected variable -> gives precedence access priority to extended classes (?)

	a method like seen below, can also be abstract => meaning that the method will not be implemented here, it comes as a placeholder for implementation at child!
	each child which extends this class must poses a method like such which is implemented as needed.
	you can have an abstract class without any abstract method included within it, BUT -
	abstract methods can only reside within an abstract class (if you have abstract method, class must be abstract as well)
	*/
	// fields (private) - all the properties of object  => NONE!
	// constructor - initialize the properties  => NONE!
	// getters & setters methods for wrapping the class this.variables private encapsulation  => NONE!
	// all-info toString()  => NONE!
	/** other methods wrapping methods...*/
	// All shapes must contain the following methods implemented:
	public abstract double calcArea(); // abstract method will never be implemented (and will always be part of an abstract class) => the implementation is at the child level!
	public abstract void printData(); //  ^  same as above...
	
	// end of class -------------
}
