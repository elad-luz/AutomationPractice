package c_java.encapsulation.a;

public class Student {
	/** Class Example 0
    	note: this class is not a main method - it is just a template that defines any student object
    	you need to run it from main to fill the college program with student object instances -
	 */ // the following, is the proper way to define Classes:
	/* upon use such object properties -
	   they can be accessed from anywhere, thus they're not protected -
	   so we need to encapsulate them to protect them - we do it by turning them to private.
	   this type of variables are good for the first phase, where you can access them directly from main:
	   - String fName;
	   - String lName;
	   - int age;
	   after turning them to private we can only access them from this class by relevant methods.
	   we have predefined methods we can use: constructor, getters & setters... ('right-click' > 'source' > 'generate...')
	   - to create a constructor automatically, click: 'Source button' + 'Create...' - it allows the ease of declare + initiate the object from main at once...
	   - to create getters & setters automatically, click: 'Source button' + 'Create...' - it allows the ease of get + set each property value of that object...
	   - to add other methods we think we need we can write them ourselves or use predefined (e.g printout of all => click: 'Source button'+'Create toString()'.
	   */	
	
	// 1. template fields (features / attributes) => variables which are a part of every object instance (turned private):
	private String fName;
	private String lName;
	private String eMail;
	private String phone;
	private int age;
	private double gradeAvg;
	private boolean active;
	
	// 2. Constructor -> delete the redundant => super();
	public Student(String fName, String lName, String eMail, String phone, int age, double gradeAvg, boolean active) {
		this.fName = fName; // Note that the "this." is to differentiate between the local-method variable & the class variable (because they are given the same name)
		this.lName = lName;
		this.eMail = eMail;
		this.phone = phone;
		this.age = age;
		this.gradeAvg = gradeAvg;
		this.active = active;
	}

	// 3. getters & setters:
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) { // Note we can add code to any setter (or other for that matter), so we'll make better inputs!
		if (age < 0 || age > 120) {
			System.out.println("attempt to set illegal age (negative or to old) - please try to set again properly");
		} else {
			this.age = age;
		}
	}

	public double getGradeAvg() {
		return gradeAvg;
	}

	public void setGradeAvg(double gradeAvg) {
		this.gradeAvg = gradeAvg;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	// 4. other methods we want to add...
	
	// toString printout method -> delete the redundant => @Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", eMail=" + eMail + ", phone=" + phone + ", age=" + age
				+ ", gradeAvg=" + gradeAvg + ", active=" + active + "]";
	}
	
	// we can add more methods to find if any string contains a sub-string, or to get the max \ min gradeAvg etc...

}
//end of class -------------
