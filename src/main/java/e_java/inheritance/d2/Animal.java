package e_java.inheritance.d2;

public abstract class Animal { // ABSTRACT !
/** Notes
	The class is Abstract (so you will NOT be able to create an object of this class) but all inheritance still take effect
	*/
	boolean breath;
	boolean move;
	int iLegs;
	
	public Animal(boolean breath, boolean move) {
		super();
		this.breath = breath;
		this.move = move;
		
	}

	public boolean isBreath() {
		return breath;
	}

	public void setBreath(boolean breath) {
		this.breath = breath;
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}
	
	public int getiLegs()
	{
		return -1;
	}
	
	public void howDoYouLive() {
		System.out.println("I breath oxygen");
	}
	
	public void howManyLegs() 
	{
		int numberOfLegs = getiLegs();
		if (numberOfLegs < 0)
		{
			System.out.println("To general");
		}
		else
		{
			System.out.println("Number of legs: " + numberOfLegs);
		}
	}
}
