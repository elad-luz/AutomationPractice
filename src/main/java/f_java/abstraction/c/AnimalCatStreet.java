package f_java.abstraction.c;

public class AnimalCatStreet extends AnimalCat {
	// template attributes variables
	private String adress;
	public boolean Castrated;
	
	// constructor
	public AnimalCatStreet(String c, double w, String n, double a, String adress, boolean Castrated) {
		super(c, w, n, a);
		this.adress = adress;
		this.Castrated = Castrated;
	}
	
	// get-set
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public boolean isCastrated() {
		return Castrated;
	}
	public void setCastrated(boolean Castrated) {
		this.Castrated = Castrated;
	}
	
	// more methods
	public void printStreetCatInfo() { // printout info
		System.out.println("Cat resides on: " + getAdress() + " | Castrated: " + isCastrated());
	}
}

