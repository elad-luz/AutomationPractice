package c_java.encapsulation.b;

public class Dog {
	/** Example 1
    	note: this class is not a main method - it is just a template that defines any Dog object
    	you need to run it from main to fill the pet program with Dog object instances -
		---
	    note: the public is open to set \ get from everywhere - and it is too vulnerable, so it is changed to private 
	    after changing to private you need to use set \ get methods & constructor
	   - to create a constructor automatically, click: 'Source button' + 'Create...' - it allows the ease of declare + initiate the object from main at once...
	   - to create getters & setters automatically, click: 'Source button' + 'Create...' - it allows the ease of get + set each property value of that object...
	   - to add other methods we think we need we can write them ourselves or use predefined (e.g printout of all => click: 'Source button'+'Create toString()'.
	 */
	//public String name;
	//public String type;
	//public int age;

		// instance's fields attributes
		private String name;
		private String type;
		private int age;
		
		// constructor -> delete the redundant => super();
		public Dog(String name, String type, int age) {
			this.name = name; // Note that the "this." is to differentiate between the local-method variable & the class variable (because they are given the same name)
			this.type = type;
			this.age = age;
		}
		// getters & setters per field:
		// name
		public String getName() {  // getter - this method GETs the fields' value of an instance-object
			return name;
		}
		public void setName(String name) { // setter - this method SETs a new fields' value for instance-object
			this.name = name; // represents <this class>.<field> 
		}
		// type
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		// age
		public int getAge() {
			return age;
		}
		public void setAge(int age) { // a setter that was added an input validation + correction
				if (age < 0)
					age = 3;
			this.age = age;
		}
		
		// to string - print all asked for Object info:
		public String toString() {
			return "Dog [name=" + name + ", type=" + type + ", age=" + age + "]";
		}
		
		// print fields' info => you can also use the predefined toString() method (see after)
		public void printInfo() { // a method that prints all values of an instance-object
//			System.out.println("instance name is: " + getName());
//			System.out.println("instance type is: " + getType());
//			System.out.println("instance age is: " + getAge());
			System.out.println("Dog instance: " + getName() + ", is " + getAge() + " years old " + getType() + " dog. \n");
		}
				
}
// end of class -------------
