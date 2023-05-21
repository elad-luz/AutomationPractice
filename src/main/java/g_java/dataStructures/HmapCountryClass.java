package g_java.dataStructures;

public class HmapCountryClass {
	/** Note
	*/
	// fields (private) - all the properties of object
	private String sCountry;
	private String sCapital;
	private int iAreaCode;
	// constructor - initialize the properties
	public HmapCountryClass(String sCountry, String sCapital, int iAreaCode) {
		this.sCountry = sCountry;
		this.sCapital = sCapital;
		this.iAreaCode = iAreaCode;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public String getsCountry() {
		return sCountry;
	}
	public void setsCountry(String sCountry) {
		this.sCountry = sCountry;
	}
	public String getsCapital() {
		return sCapital;
	}
	public void setsCapital(String sCapital) {
		this.sCapital = sCapital;
	}
	public int getiAreaCode() {
		return iAreaCode;
	}
	public void setiAreaCode(int iAreaCode) {
		this.iAreaCode = iAreaCode;
	}
	// all-info toString() @Override -> you need to concatenate: ' + super.toString()'; [so super will not be run over] => Note: it can be added automatically during adding the method
	@Override
	public String toString() {
		return "MapCountryClass [sCountry=" + sCountry + ", sCapital=" + sCapital + ", iAreaCode=" + iAreaCode + "]";
	}
	/** other methods wrapping above methods...*/
	// implement abstract method from parent
	// end of class -------------
}
