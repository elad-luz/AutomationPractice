package d_java.composition.d;

import java.util.Arrays;

public class Car {
	/* PLAESE NOTE
	   There are various ways to implement stuff, to construct objects & to use hierarchy-driven methods (many ways to do the same thing) !
	   Look carefully below on the comments, and try to understand the diff of what was made, why & how !
	 */
	// fields - all the properties of the Car
	private String firm; // for ease, use the simple attribute first, and the complex class ones at bottom
	private String model;
	private long year;
	private CarRadio radio; // Note that radio don't need any input during construction, so we can use it as is during making of a Car
	private CarWheel[] wheels; // note that the array of wheels is declared here (unlike stations in radio)
	// in this case the wheels array is going to be constructed at maim via creation...
	
	// constructor - initialize the properties
	public Car(String firm, String model, long year, CarWheel[] wheels) { // the 'CarRadio radio,' part was taken out because we use it pre-defined within constructor
		this.firm = firm;
		this.model = model;
		this.year = year;
		// this.radio = radio; // this was taken out because we use it pre-defined within constructor:
		this.radio = new CarRadio(); // this is the way to initialize it from Car class & will be reached to via CAR instance...
		this.wheels = wheels;
	}
	
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public CarRadio getRadio() {
		return radio;
	}
	public void setRadio(CarRadio radio) {
		this.radio = radio;
	}
	public CarWheel[] getWheels() {
		return wheels;
	}
	public void setWheels(CarWheel[] wheels) {
		this.wheels = wheels;
	}
	
	// all-info to string
	public String toString() {
		return "Car [firm=" + firm + ", model=" + model + ", year=" + year + ", radio=" + radio + ", wheels="
				+ Arrays.toString(wheels) + "]";
	}
	/** other methods wrapping methods...*/
	
	public void radioOn() { // using the above method to getRadio & set from CarRadio Class
		getRadio().setOn(true); // will set ON
	}
	
	public void radioOff() { // using the above method to getRadio & set from CarRadio Class
		getRadio().setOn(false); // will set OF
	}

	// getRadioState (same as CarRadio.isOn() but from Car)
	public boolean getRadioState() {
		return getRadio().isOn(); // this will fetch the data starting at this class, using CarRadio getRadio() method to go to CarRadio & get that data from it
	}
	
	public void changeStation(int newStattion) { // using the above method to getRadio & set from CarRadio Class
		if (getRadio().isOn()) { // same as with == true
			getRadio().setSelectedStation(newStattion); // will set station in array,
			// note that because first station is array[0] you need a mechanism to straight it
		}	
	}
	
	public int getCurrentStation() { // gets the selected station
		return getRadio().getSelectedStation();	// note that because first station is array[0] you need a mechanism to straight it
	}

	// note that here we go back 2 classes to fetch info
	public String getCurrentStationName() { // gets the selected station Name
		// if (getRadio().isOn()) { // I could have also wrap it with if working...
		int selectedCellStation = getRadio().getSelectedStation(); // this will get the selected station cell [?]
		String stationName = getRadio().getStations()[selectedCellStation].getStationName();	// this will get the array & find the cell and will use the CarRadioStation getter, for the name 
		return stationName; // now we return the String (not printing it) of the name !!!
		// } else return "Radio is OFF"; // upon using IF & radio is closed - return 'Radio is OFF' ...
	}
	
	public void printWheelsInfo() {
		for (int i = 0; i < wheels.length; i++) { // wheels -&- getWheels is eventually the same (see above, in getter).
			System.out.println(wheels[i].toString()); // print each one (can use also the toString method from Wheels...
			// Note that (wheels[i]) is also good -> you can drop the '.toString()' & it will still work as well because it is a default case handled !
			// Also, should you want to return pressure use: wheels[i].getAirPressure()
		}
	}
	
	// OOPS... upon one wheel pressure drop = Puncture => switch it with the spare one with the flat one
	public void wheelPuncture (int wheelPosition) {
		getWheels()[wheelPosition].setAirPressure(0); // no need for -1 because the first in array [0] is the spare one
		CarWheel punctureWheel = getWheels()[wheelPosition]; // create a TEMP variable to hold data during switch...
		getWheels()[wheelPosition] = getWheels()[0]; // put the Spare Wheel with good pressure instead of the punctured one
		getWheels()[0] = punctureWheel; // put the punctureWheel with zero pressure instead of the Spare one
	}
	// end of class -------------
}
/** from another solution:
public class Automobile {
	int yearModel;
	String firm;
	Engine engine; //define Engine object
	Wheel [] wheels = new Wheel[5]; //define array of 5 wheels
	Radio radio; //define Radio object
	
	public Automobile(String firm, int year) {
		engine = new Engine(110, 4, false);
		radio = new Radio();
		wheels[0] = new Wheel(28);
		wheels[1] = new Wheel(28);
		wheels[2] = new Wheel(28);
		wheels[3] = new Wheel(28);
		wheels[4] = new Wheel(20);
		
		this.firm = firm;
		this.yearModel = year;
	}
	
	public void printData()
	{
		System.out.println("Firm: " + firm + " Year: " + yearModel);		
	}
	
	public void printHp()
	{
		System.out.println("Horse Power: " + engine.getHorsePower());
	}
	
	public void turnRadioOn(){
		radio.setRadioTurnedOn(true);
	}
	
	public void getRadioState()
	{
		if (radio.isRadioTurnedOn()){
			System.out.println("Radio is currently truned on!");
		}
		else{
			System.out.println("Radio is currently turned off!");
		}
	}
	
	public boolean isRadioOn(){
		return radio.isRadioTurnedOn();
	}
	
	public void getStationName(){
		if (radio.isRadioTurnedOn()){
			System.out.println("Currently playing - " + radio.getStationName());
		}
		else
			System.out.println("Radio turned off! Please turn radio on to get station name!");
		}
	
	public void changeRadioStation(int selectRadioStation){
		if (radio.isRadioTurnedOn()){
			radio.selectedStation = selectRadioStation;
		}
		else{
			System.out.println("Radio turned off! Please turn Radio ON to change station!!");
		}
	}
	
	public void turnRadioOff(){
		radio.setRadioTurnedOn(false);
	}
	
	public void printTireStatus(){
		for (int i = 0 ; i < wheels.length; i++){
			if (i != 4)
				System.out.println("Air pressure for wheel number "+ (i+1) + " is " + wheels[i].airPressure);
			else
				System.out.println("Spare Tire Air pressure is " + wheels[i].airPressure);
		}
	}
	
	public void simulateFlatTire(int tireNumber){
		tireNumber--;
		wheels[tireNumber].setAirPressure(0);
		printTireStatus();
		System.out.println("Switching tires!!");
		wheels[tireNumber].airPressure = wheels[4].airPressure;
		wheels[4].airPressure = 0;
		printTireStatus();
	}
}
 */