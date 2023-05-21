package h_java.exercises.polymoCases1a;

public class Square extends Rectangle { // the square is actually a kind of rectangle !!!
	// if abstract method in parent is not implemented yet -> click on the class Name & choose 'Add unimplemented methods'...

	// fields (private) - all the properties of object => Not needed because it is defined by Rectangle

	public Square(String color, double side) { // instead of width, height we can use side => orig constructor: Square(String color, double width, double height)
		super(color, side, side); // orig was (color, width, height);
	}
	
	/** other methods wrapping above methods...*/
	
	// all methods are the same as parent, beside one: implement abstract method from parent
	@Override
	public void printData() {
		System.out.println("I am a 'square' and my area is: " + calcArea());
	}
	// end of class -------------
}
