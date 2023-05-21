package e_java.inheritance.d2;

public class AnimalMammelApe extends AnimalMammel {

	boolean isHairy;
	int iLegs;

	public AnimalMammelApe(boolean breath, boolean move, boolean hotblood, boolean isHairy, int iLegs) {
		super(breath, move, hotblood);
		this.isHairy = isHairy;
		this.iLegs = iLegs;
	}
	public boolean isHairy() {
		return isHairy;
	}
	public void setHairy(boolean isHairy) {
		this.isHairy = true;
	}
	public int getiLegs() {
		return 2;
	}
	public void setiLegs(int iLegs) {
		this.iLegs = iLegs;
	}

}
