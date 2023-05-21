package g_java.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions_5 {

	public static void main(String[] args) {
		System.out.println("Exceptions 5:\n=============\n");

		System.out.println("1)"); // section 1 working with Files:
		// File (state the path of file) FileReader (reeds the file)
		// how to read a file -- needs import of classes: File & FileReader
		// because we work with files the class knows that there can be a common problem during run of "file not found"
		// so as a pre-condition, you are asked to handle this issue prior to run - so in case it happens the code will not crash!
		File file = new File("C:\\Users\\USER\\eclipse-workspace\\TEMP.txt"); // TEMP.txt exist - if name will be changed, the path indicates a not exist file
		System.out.println("my file name is: " + file.getName()); // this object don't care if the actual file exists or not, just that object got a proper path
		
		try {
		      try (// Creates a reader using the FileReader => to Closes the reader: readerName.close();
			FileReader fReader = new FileReader(file)) {
				System.out.println("file path: " + file);
				System.out.println(fReader.getEncoding());
				fReader.close(); // close the resource
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) { // IF problem spotted (only upon encounter) => give a FileNotFoundException (this is also an object class needs to be imported !
			// Auto-generated catch block: e1.printStackTrace();
			e1.printStackTrace();
			System.out.println("file: " + file + " is not found");
		}
/* the below was simplify example but eclipse demands it should be wrapped with another try-catch!
		try {
		      // Creates a reader using the FileReader => to Closes the reader: readerName.close();
			FileReader fReader = new FileReader(file); // this operation request me to wrap it with throws & try\catch
			System.out.println("file path: " + file);
			System.out.println(fReader.getEncoding());
		} catch (FileNotFoundException e1) { // IF problem spotted (only upon encounter) => give a FileNotFoundException (this is also an object class needs to be imported !
			// Auto-generated catch block: e1.printStackTrace();
			e1.printStackTrace();
			System.out.println("file: " + file + " is not found");
		}
*/
		System.out.println("end of section 1");

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		System.out.println("2)"); // section 2 => FileInputStream:
		// exception is an error caught not by the runtime compiler - you need to check it during your run:
		// you need to let java know how to handle this kind of exception within your code (before runtime)
		// you must wrap the problematic code with try block:
		FileInputStream fis1 = null;
		try {
			fis1 = new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\TEMP.txt"); // if I'll try to code only this kind, java will tell me I must pre-handle the exception	
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		
		finally { // releases all system resources from the streams
			System.out.println("finally close...");
			try {
				if (fis1 != null)
					fis1.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}		
		// =================================
		System.out.println("\n--- end ---");
	}  // end of main
	/** METHODS (out-side of 'main'): */
	// this method will: do what.. (get what... -&- return what...):
	// or..., if using a method - you can state the exception from this method will be handled in main method
	public static void method1() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\TEMP.txt"); // if I'll try to code only this kind, java will tell me I must pre-handle the exception

		int i = fis.read();

		char c = (char) i;

		System.out.println(c);

		fis.close(); // close file input stream
	}
}
