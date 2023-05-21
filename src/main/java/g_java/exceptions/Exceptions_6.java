package g_java.exceptions;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions_6 {

	public static void main(String[] args) throws IOException {
		System.out.println("Exceptions 6:\n=============\n");

		System.out.println("1)"); // Working on file

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\eclipse-workspace\\TEMP.txt"));
		String name = "Elad";
		String substr = "Auto";
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				if (line.contains(substr))
					System.out.println(line + " contains: " + substr);
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			if (everything.contains(name))
				System.out.println("found name: " + name);
		} finally {
			br.close();
		}
		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */
	// this method will: do..., you can state the exception from this method will be handled in main method (thrown)
}
