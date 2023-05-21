package e_java.inheritance.d2;

public class AnimalMammel extends Animal {

	private boolean hotblood;

	public AnimalMammel(boolean breath, boolean move, boolean hotblood) {
		super(breath, move);
		this.hotblood = true;
	}

	public boolean isHotblood() {
		return hotblood;
	}

	public void setHotblood(boolean hotblood) {
		this.hotblood = hotblood;
	}
}
