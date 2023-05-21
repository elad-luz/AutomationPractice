package e_java.inheritance.d2;

public class AnimalReptile extends Animal {

	private boolean hotblood;

	public AnimalReptile(boolean breath, boolean move, boolean hotblood) {
		super(breath, move);
		this.hotblood = false;
	}

	public boolean isHotblood() {
		return hotblood;
	}

	public void setHotblood(boolean hotblood) {
		this.hotblood = hotblood;
	}
}
