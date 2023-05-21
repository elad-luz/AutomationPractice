package a_java.basicsCMD;

public class DemoCMD {
	/** https://selenium.teachable.com/courses/157997/lectures/2475509 - Using CMD:
	0. Open MS Windows CMD...
	
	1. via class properties in eclipse > find location of folder = dir > go to dir path
	C:\Users\USER>cd C:\Users\USER\eclipse-workspace\JavaCourses\src\a_java\basicsCMD

	2. verify if exe exist (if not make sure it is & also in system variables (as path)
	C:\Users\USER\eclipse-workspace\JavaCourses\src\a_java\basicsCMD>Javac -version
	javac 11.0.16

	3. compile the class (see runnable class added to that location)
	C:\Users\USER\eclipse-workspace\JavaCourses\src\a_java\basicsCMD>Javac DemoCMD.java

	4. back to src for RUN
	C:\Users\USER\eclipse-workspace\DemoCMD\src\a_java\basicsCMD>cd ..
	C:\Users\USER\eclipse-workspace\DemoCMD\src\a_java>cd ..

	5. RUN (using path from src)
	C:\Users\USER\eclipse-workspace\DemoCMD\src>java a_java.basicsCMD.DemoCMD
	this is my cmd class
	*/
	public static void main(String[] args) {
		// TO Compile & Run via Command Line:
		String message = "this is my cmd class";
		System.out.println(message);
	}
}
