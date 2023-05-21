package c_java.encapsulation.b;

public class Cat {
	/** Example 1
    	note: this class is not a main method - it is just a template that defines any Cat object
    	you need to run it from main to fill the Pet program with Cat object instances -
		---
	    note: the public is open to set \ get from everywhere - and it is too vulnerable, so it is changed to private 
	    after changing to private you need to use set \ get methods & constructor ('right-click' > 'source' > 'generate...')
	   - to create a constructor automatically, click: 'Source button' + 'Create...' - it allows the ease of declare + initiate the object from main at once...
	   - to create getters & setters automatically, click: 'Source button' + 'Create...' - it allows the ease of get + set each property value of that object...
	   - to add other methods we think we need we can write them ourselves or use predefined (e.g printout of all => click: 'Source button'+'Create toString()'.
	 */
	//public String name;
	//public String type;
	//public int age;

		// 1. template fields (features / attributes) => variables which are a part of every object instance - 'private' access specifier can be access Only from within the class it is defined in!
		private String name;  // Note that the "this." is to differentiate between the local-method variable & the class variable (because they are given the same name)
		private String type;
		private int age;
		public static boolean haveTail = true; // same for all instances - would be automatically set by default during object initiation
		
		// 2. constructor (for setting input to all attributes at once, when made) -> delete the redundant => super();
		public Cat(String name, String type, int age) {
			this.name = name; // Note that the "this." is to differentiate between the local-method variable & the class variable (because they are given the same name)
			this.type = type;
			// age set with input validation + correction...
			if (age < 0) { // we can add in constructor a Decision-Making for better protecting our objects
				this.age = 0; // in this case it is not possible to enter negative age - it will be entered as zero !
			} else
				this.age = age; // if positive age - it will be set regularly as entered !
		}
		
		public Cat(String name) { // its possible to add constructor for only one attribute [if we want to add later on the others]
			this.name = name; // here we will only insert the name
		}

		// 3. getters & setters per field: get\set the value from\to field variable of object instance... get-set methods can hold code & logics!
		public String getName() {  // name -> getter: this method GETs the name field value of an instance-object
			return name;
		}
		public void setName(String name) { // name -> setter: this method SETs a new name field value for instance-object
			this.name = name; // represents <this class>.<field> 
		}
		public String getType() { // type
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getAge() { // age
			return age;
		}
		public void setAge(int age) { // this setter was added with an input validation for no negative age + correction as an example
				if (age < 0)
					age = 0;
			this.age = age;
		}
		public static boolean isHaveTail() { // always true
			return haveTail;
		}
		public static void setHaveTail(boolean haveTail) { // 'static' - automatically set as true 
			Cat.haveTail = haveTail;
		}
		
		// 4. to string - print all asked for Object info:
		public String toString() {
			return "Cat [name=" + name + ", type=" + type + ", age=" + age + "]";
		}
		
		//5. Extra:
		// print fields' info => you can also use the predefined toString() method (see after)
		public void printInfo() { // a method that prints all values of an instance-object
//			System.out.println("instance name is: " + getName());
//			System.out.println("instance type is: " + getType());
//			System.out.println("instance age is: " + getAge());
			System.out.println("Cat instance: " + getName() + ", is " + getAge() + " years old " + getType() + " cat | with tail -> " + Cat.haveTail + ". \n");
		}

		// future age adding given years
		public double futureAge(double year) { // a method that return a value of age + int given
			return (getAge() + year);
		}

		
}
// end of class -------------
