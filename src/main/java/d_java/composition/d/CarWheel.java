package d_java.composition.d;

public class CarWheel {
	
	// fields - all the properties of the CarRadio
	private int diameter;
	private String manufactur;
	private double airPressure;
	
	// constructor - initialize the properties - not needed in this case!
	public CarWheel(int diameter, String manufactur, double airPressure) {
		this.diameter = diameter;
		this.manufactur = manufactur;
		this.airPressure = airPressure;
	}
	
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	public String getManufactur() {
		return manufactur;
	}
	public void setManufactur(String manufactur) {
		this.manufactur = manufactur;
	}
	public double getAirPressure() {
		return airPressure;
	}
	public void setAirPressure(double airPressure) {
		this.airPressure = airPressure;
	}

	// all-info to string
	public String toString() {
		return "CarWheel [diameter=" + diameter + ", manufactur=" + manufactur + ", airPressure=" + airPressure + "]";
	}
	/** other methods wrapping methods...*/	
	// end of class -------------
}
