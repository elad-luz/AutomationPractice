package d_java.composition.b;

public class Computer { // this class is also composed of an author class
	/* anyComputer is composed of:
	 * manufacture 
	 * year
	 * color
	 * price
	 * hardDisk:  need to be predefined by another class with:
		- manufacture 
		- ssd
		- size
	 * CPU:  need to be predefined by another class with:
		- model
		- speed
		- coresNumber
	 * turnedON (should be set by default as false, till actually turned-on!
	 */
	// fields
	private String manufacture;
	private long year;
	private String color;
	private double price;
	private ComputorHardDisk hardDisk; // composition !!!
	private ComputerCPU cpu; // composition !!!
	private boolean turnedON; // could have been -> private boolean turnedON = false; => BUT better to do from constructor !
		
	// constructor
	public Computer(String manufacture, long year, String color, double price, ComputorHardDisk hardDisk, ComputerCPU cpu) {
		this.manufacture = manufacture;
		this.year = year;
		this.color = color;
		this.price = price;
		this.hardDisk = hardDisk;
		this.cpu = cpu;
		this.turnedON = false; // Note that it was not added to construction method variables, because its set by default during construction as false - and stay till actually turned-on
	}

	// get | set // if the turnedON was later added as a variable feature of computer, you can add the getter/setter only of that...
	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ComputorHardDisk getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(ComputorHardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}

	public ComputerCPU getCpu() {
		return cpu;
	}

	public void setCpu(ComputerCPU cpu) {
		this.cpu = cpu;
	}

	public boolean isTurnedON() {
		return turnedON;
	}

	public void setTurnedON(boolean turnedON) { // this also being wrapped bellow
		this.turnedON = turnedON;
	}

	// all-info to string // added turnedON at the end (or recreate the toString)
	public String toString() {
		return "anyComputer [manufacture=" + manufacture + ", year=" + year + ", color=" + color + ", price=" + price
				+ ", hardDisk=" + hardDisk + ", cpu=" + cpu + ", turnedON=" + turnedON + "]";
	}
	
	// More Methods wrapping other methods
	public void start() { // this method wrap above (setTurnedON) & set as true (access directly)
		setTurnedON(true); // this is how to use it directly
	}
	
	public void stop() { // this method wrap above (setTurnedON) & set as false (access directly)
		setTurnedON(false);
	}
	
	// end of class -------------
}
