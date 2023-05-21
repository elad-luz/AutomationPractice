package d_java.composition.a;

public class BookAuthor { // NOTE that bookAuthor will be used by anyBook Class
	// fields
	private String name;
	private String address;
	
	// constructor
	public BookAuthor(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	// get | set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// all-info
	public String toString() {
		return "author [name=" + name + ", address=" + address + "]";
	}
	
	// get fields' info for Author name & price
	public String getInfo() {
		String info = this.name + "," + this.address;
		return info;
	}
	
	// print fields' info for Author
	public void printInfo() { // a method that prints all values of an instance-object
		System.out.println("Publisher instance info: " + getName() + " , " + getAddress());
	}

}
