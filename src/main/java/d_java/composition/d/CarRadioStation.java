package d_java.composition.d;

public class CarRadioStation {
	
	// fields - all the properties of the CarRadioStation
	private String stationName;
	private double stationFrequency;
	
	// constructor - initialize the properties
	public CarRadioStation(String stationName, double stationFrequency) {
		this.stationName = stationName;
		this.stationFrequency = stationFrequency;
	}
	
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public double getStationFrequency() {
		return stationFrequency;
	}
	public void setStationFrequency(double stationFrequency) {
		this.stationFrequency = stationFrequency;
	}
	
	// all-info to string
	public String toString() {
		return "CarRadioStation [stationName=" + stationName + ", stationFrequency=" + stationFrequency + "]";
	}
	/** other methods wrapping methods...*/	
	// end of class -------------
}
