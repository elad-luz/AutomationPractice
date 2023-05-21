package d_java.composition.a;

public class Book { // this class is also composed of an author class
	/* composition is a "has-a" relationship:
	 * you do composition by having an instance of another class, as a field of your class
	 * one class is composed of object defined in another class
	 * the top class containing the others is hiding them (encapsulating) and exposes them in an interface
	 * an interface is a reference type in Java, similar to class - It is a collection of abstract methods
	 * a class implements an interface, thereby inheriting the abstract methods of the interface

	 * the class which all books objects will be defined in is: "booksShop" which is the MAIN !!!
	 * the 'public' definition is open to set \ get from everywhere - and it is too vulnerable, so it is changed to 'private'
	 * after changing definition to 'private' you need to use 'get' \ 'set' or 'constructor' methods (if 'none' is defined, it is reachable from project)
	 */

	// fields -> instance's attributes - NOTE: the variables declaration & initiation will be done by following construction in MAIM
	private String name; // type: String
	private int year; // type: int
	private double price; // type: double
	private BookAuthor author; // type: bookAuthor is the type (defined in another class) & author is the name of this variable stating this object
	// NOTE that this will actually be populated by other class => book is linked to reference bookAuthor Class by this parameter: author!
	private BookPublisher publisher; // type: bookPublisher is the type (defined in another class) & publisher is the name of this variable stating this object
	// As for author above, this parameter will actually be populated by other class => booksPublisher Class...

	
	// constructor
	/*	constructors how to: you can stand on all fields and => 'right-click' > 'source' > 'generate constructors'
		constructors: a short way that replace the setters in a given template
		it will be use for quick & easy 'set value' to a specific setting template [can be more than one]
		this constructor will set values to ALL fields defined in this constructor
	*/ 
	public Book(String name, int year, double price, BookAuthor author, BookPublisher publisher) {
		// super(); // to be deleted for now...
		this.name = name;
		this.year = year;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}
	// this constructor will set values to Only Book fields without Author & Publisher
	public Book(String name, int year, double price) { // a set template with only several fields (not all)
		this.name = name;
		this.year = year;
		this.price = price;
	}

	// get | set
	/*	getters & setters how to: you can stand on all fields and => 'right-click' > 'source' > 'generate getters & setters'
	This method gets a @param name of String and set a new name to it
 	public void setName(String name) {this.name = name;} // this.name represent the field X.name
 	*/	
	public String getName() { // getter - this method GETs the fields' value of an instance-object and return it to memory
		return name;
	}

	public void setName(String name) { // setter - this method SETs a new fields' value for instance-object
		this.name = name; // represents <this class>.<field> [ the 'this' refers to the class variable up above, the = X refers to the vars in brackets -> String X ]
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) { // a setter that was added an input validation + correction (price smaller than zero will be set as 0)
		if (price < 0)
			price = 0;	
		this.price = price;
	}

	// following are using other classes = composition
	// getAuthor - reference to bookAuthor
	// getPublisher - reference to bookPublisher
	
	public BookAuthor getAuthor() {
		return author;
	}

	public void setAuthor(BookAuthor author) {
		this.author = author;
	}

	public BookPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(BookPublisher publisher) {
		this.publisher = publisher;
	}

	// all-info
	public String toString() {
		return "book [name=" + name + ", year=" + year + ", price=" + price + ", author=" + author + ", publisher=" + publisher + "]";
	}

	// get fields' info for Book name & price
	public String getInfo() {
		String info = this.name + "," + this.year + "," + this.price + "," + this.author + "," + this.publisher;
		return info;
	}

	// return Author
	public String whoIsTheAuthor() {
		String theAuthor = author.getName() + " is the author";
		return theAuthor; // this is the String being returned
	}
	/** if you just want to return the Author you can do:
	   	public String whoIsTheAuthor() {
		return this.author.getName();
	or: return this.author; // same
	or: return author; // same
	} // this string must be printed at main !
	 */

	// return Publisher
	public String whoIsThePublisher() {
		String thePublisher = publisher.getName() + " is the publisher";
		return thePublisher;
	}

	// print fields' info for Book (including Author & Publisher)
	public void printInfo() { // a method that prints all values of an instance-object
		System.out.println("Book instance info: " + getName() + " , " + getYear() +  " , " + getPrice());
		author.printInfo();
		publisher.printInfo();
		System.out.println("\n");
	}
	
	//price minus a discount (deduct from price only positive number)
	public double discountPrice(double discount) { // a method that returns a value of price minus a given discount
		if (discount < 0)
			discount = 0;	
		return (getPrice() - discount); // if price is 0 it might be negative
	}
	// end of class -------------
}
