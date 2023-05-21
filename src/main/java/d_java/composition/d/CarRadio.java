package d_java.composition.d;

import java.util.Arrays;

public class CarRadio {
	
	// fields - all the properties of the CarRadio
	private boolean on;
	private int selectedStation;
	private CarRadioStation stations[]; // just declare the array of objects...
	// IF I use this without predefined input (see comment below) I must define & initiate the stations array via MAIN upon creation of CAR !
	
	// constructor - initialize the properties - not all features are needed to be given - some can be predefined!
	/** public CarRadio(CarRadioStation[] stations) { // if you won't use the pre-set init of array value, you'll have to use this & do it from MAIM !!! */
	public CarRadio() { // in our case the constructor con't require any input, because all is pre-set in advance !
		this.on = false; // predefined - radio first mode is OFF
		this.selectedStation = 0; // predefined: 0 is the first in array will be set as default => first station (so we could make a mechanism to set +1)
		/** this.stations = stations; // if you won't use the pre-set init of array value, you'll have to use this & do it from MAIM !!! */
		// using the following way, you can initialize via constructor the pre-set the already declared array (above), so each radio will have it upon creation
		this.stations = new CarRadioStation[6]; // initialization of stations[6] array with predefined values
		stations[0] = new CarRadioStation("88FM",88.0);
		stations[1] = new CarRadioStation("GLTZ",96.6);
		stations[2] = new CarRadioStation("GLGLTZ",91.8);
		stations[3] = new CarRadioStation("Reshet B",95.5);
		stations[4] = new CarRadioStation("Radius",100.00);
		stations[5] = new CarRadioStation("ECO",99.00);
	}
	
	// getters & setters methods for wrapping the class this.variables private encapsulation

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public int getSelectedStation() {
		return selectedStation;
	}

	public void setSelectedStation(int selectedStation) {
		this.selectedStation = selectedStation;
	}

	public CarRadioStation[] getStations() {
		return stations;
	}

	public void setStations(CarRadioStation[] stations) {
		this.stations = stations;
	}
	
	// all-info to string
	public String toString() {
		return "CarRadio [on=" + on + ", selectedStation=" + selectedStation + ", stations=" + Arrays.toString(stations)
				+ "]";
	}
	/** other methods wrapping methods...*/
	// start & stop radio would be implemented as part of Car, because you do it from car !
	
	// print name & frequency of current station from array
	public void printSelectedStationInfo() {
	System.out.println("Selected Station Info: " + stations[selectedStation].toString());
	}
	// we can add a get method to fetch only name of station => I will implement this on Car level
		
	// end of class -------------
}
/** from another solution:
public class Radio {
	
	Station [] station = new Station[5];
	boolean radioTurnedOn = false;
	int selectedStation = 1;
	
	public Radio (){ // constructor empty from inputs
		station[0] = new Station("GLTZ",96.6);
		station[1] = new Station("GLGLTZ",91.8);
		station[2] = new Station("Reshet B",95.5);
		station[3] = new Station("Radius",100.00);
		station[4] = new Station("ECO",99.00);
	}

	public boolean isRadioTurnedOn() {
		return radioTurnedOn;
	}

	public void setRadioTurnedOn(boolean radioTurnedOn) {
		this.radioTurnedOn = radioTurnedOn;
	}

	public void setSelectedStation(int stationNumber){
		this.selectedStation = stationNumber;
	}

	public String getStationName(){
		return station[selectedStation].stationName;
	}
}
 */