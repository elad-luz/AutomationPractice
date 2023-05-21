package d_java.composition.a;

public class BookPublisher { // NOTE that bookPublisher will be used by anyBook Class

	// fields
	private String name;
	private String address;
	
	// constructor
	public BookPublisher(String name, String address) {
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
	
	// all-info to string
	public String toString() {
		return "bookPublisher [name=" + name + ", address=" + address + "]";
	}

	// get fields' info for Publisher
	public String getInfo() {
		String info = this.name + "," + this.address;
		return info;
	}
	
	// print fields' info for Publisher
	public void printInfo() { // a method that prints all values of an instance-object
		System.out.println("Publisher instance info: " + getName() + " , " + getAddress());
	}
}
