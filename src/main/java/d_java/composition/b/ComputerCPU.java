package d_java.composition.b;

public class ComputerCPU { // NOTE that computerCPU will be used by anyComputer Class
	/* computerCPU is composed of:
	 * model
	 * speed
	 * coresNumber
	 */
	// fields
	private String model;
	private double speed;
	private long coresNumber;
	
	// constructor
	public ComputerCPU(String model, double speed, long coresNumber) {
		this.model = model;
		this.speed = speed;
		this.coresNumber = coresNumber;
	}	

	// get | set  // note that as in real world, you can't change a post-creation model of an object, so we can remove it from setters
	public String getModel() {
		return model;
	}
//  the setter was removed & model can only be defined upon creation & not change any more
//	public void setModel(String model) {
//		this.model = model;
//	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public long getCoresNumber() {
		return coresNumber;
	}

	public void setCoresNumber(long coresNumber) {
		this.coresNumber = coresNumber;
	}

	// all-info to string
	public String toString() {
		return "computerCPU [model=" + model + ", speed=" + speed + ", coresNumber=" + coresNumber + "]";
	}
	// end of class -------------
}
