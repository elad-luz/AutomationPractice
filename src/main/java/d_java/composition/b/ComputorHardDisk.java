package d_java.composition.b;

public class ComputorHardDisk { // NOTE that computerHardDisk will be used by anyComputer Class
	/* computorHardDisk is composed of:
	 * manufacture
	 * ssd
	 * size
	 */
	// fields
	private String manufacture;
	private boolean ssd;
	private long size;
	
	// constructor
	public ComputorHardDisk(String manufacture, boolean ssd, long size) {
		this.manufacture = manufacture;
		this.ssd = ssd;
		this.size = size;
	}

	// get | set // note that as in real world, you can't change a post-creation manufacture of an object, so we can remove it from setters
	public String getManufacture() {
		return manufacture;
	}
//  the setter was removed & manufacture can only be defined upon creation & not change any more
//	public void setManufacture(String manufacture) {
//		this.manufacture = manufacture;
//	}

	public boolean isSsd() {
		return ssd;
	}

	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	// all-info to string
	public String toString() {
		return "computorHardDisk [manufacture=" + manufacture + ", ssd=" + ssd + ", size=" + size + "]";
	}
	// end of class -------------
}
