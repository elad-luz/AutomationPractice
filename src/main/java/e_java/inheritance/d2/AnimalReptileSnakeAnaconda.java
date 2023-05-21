package e_java.inheritance.d2;

public class AnimalReptileSnakeAnaconda extends AnimalReptileSnake {
	boolean bVeryBig;
	int iLegs;

	public AnimalReptileSnakeAnaconda(boolean breath, boolean move, boolean hotblood, boolean bHaveLegs, boolean bVeryBig) {
		super(breath, move, hotblood, bHaveLegs);
		this.bVeryBig = bVeryBig;
	}

	public boolean isbVeryBig() {
		return true;
	}

	public void setbVeryBig(boolean bVeryBig) {
		this.bVeryBig = true;
	}

	public int getiLegs()
	{
		return 0;
	}
}
