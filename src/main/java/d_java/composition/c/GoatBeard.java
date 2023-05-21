package d_java.composition.c;

public class GoatBeard {

	// beard properties
	private boolean haveBeard;
	private int length; // if beard it true
	private String color; // if beard it true
		
	// constructor - initialize the tail properties
	public GoatBeard(boolean haveBeard, int length, String color) {
		this.haveBeard = haveBeard;
		   if (haveBeard=false)
			   this.length = 0;
		   else {
			   this.length = length;
		}
		   if (haveBeard=false)
			   this.color = "none";
		   else {
			   this.color = color;
		}
	}

	// getters & setters methods for wrapping the class this.variables private Encapsulation
	public boolean isHaveBeard() {
		return haveBeard;
	}
	public void setHaveBeard(boolean haveBeard) {
		this.haveBeard = haveBeard;
	}
	public int getLength() {
		if (haveBeard) {
			return length;
		}
		return 0;
	}
	public void setLength(int length) {
		if (haveBeard) {
		this.length = length;
		}
		this.length = 0;
	}
	public String getColor() {
		if (haveBeard) {
			return color;
		}
		return "none";
	}
	public void setColor(String Color) {
		this.color = Color;
	}

	// get all info as string
	public String toString() {
		return "GoatBeard [haveBeard=" + haveBeard + ", length=" + length + ", color=" + color + "]";
	}
	// end of class -------------
}
