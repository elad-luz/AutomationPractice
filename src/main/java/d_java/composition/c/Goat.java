package d_java.composition.c;

import java.util.Arrays;

public class Goat {
	
	// fields - all the properties of the goat
	private boolean male;
	private GoatBeard beard;
	private GoatLeg[] legs;
	private GoatTail tail;
	private String color;
	private String name;
	private int age;

	// constructor - initialize the goat properties
	public Goat(boolean male, GoatBeard beard, GoatLeg[] legs, GoatTail tail, String color, String name, int age) {
		this.male = male;
		this.beard = beard;
		this.legs = legs;
		this.tail = tail;
		this.color = color;
		this.name = name;
		this.age = age;
	}

	// getters & setters methods for wrapping the class this.variables private Encapsulation
	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public GoatBeard getBeard() {
		return beard;
	}

	public void setBeard(GoatBeard beard) {
		this.beard = beard;
	}

	public GoatLeg[] getLegs() {
		return legs;
	}

	public void setLegs(GoatLeg[] legs) {
		this.legs = legs;
	}

	public GoatTail getTail() {
		return tail;
	}

	public void setTail(GoatTail tail) {
		this.tail = tail;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// all-info to string
	public String toString() {
		return "goat [\n male=" + male + ",\n beard=" + beard + ",\n legs=" + Arrays.toString(legs) + ",\n tail=" + tail
				+ ",\n color=" + color + ",\n name=" + name + ",\n age=" + age + "]";
	}
	// end of class -------------
	
/**
	//The next methods are general methods for operations we want to implement
	public void printMyLegsSize(){
		int count=1;
		System.out.println("My Legs size are: ");
		for(Leg l:legs){
			System.out.println("My leg number " + count + " size is:" + l.getLegSize());
			count+=1;
		}
	}

	public void printMyName(){
		System.out.println("Hello, I am: " + getName());
	}

	public void printMyBeard(){
		System.out.println("Do I have a beard: " + getBeard());
		System.out.println("My beard color is: " + getBeardColor());
	}

	public void printMyTail(){
		System.out.println("I have a tail: " + getTail());
	}

	public void printMyAge(){
		System.out.println("My age is: " + getAge());
	}
	
	// This method will call all other 'print' methods
	public void printMyDescription(){
		printMyName();
		printMyAge();
		printMyBeard();
		printMyTail();
		printMyLegsSize();
	}
*/
	
}
