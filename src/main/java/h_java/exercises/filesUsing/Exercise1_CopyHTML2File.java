package h_java.exercises.filesUsing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Exercise1_CopyHTML2File {

	public static void main(String[] args) {
		System.out.println("Exercise:\n=========\n");
		
		/** notes:  copy HTML of web-page to file example
			program that take a web page url and keep it to file...
			code taken from Internet => needs importing
			https://mkyong.com/java/how-to-get-url-content-in-java/
		 */
		// URL (and others to come) is an object - and like any other, it needs to be declared and initiated with input to constructor
		URL url;

		try {
			// get URL content
			url = new URL("https://automation.co.il/"); // construct given url address
			URLConnection conn = url.openConnection(); // this method is part of the object wrapping methods that do something

			// open the stream and put it into BufferedReader (object)
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

			String inputLine;

			//save to this filename [C:\Users\USER\eclipse-workspace\JavaCourses\src\h_java\Exercises\FilesUsing\download_automation-co-il.html]
			String fileName = "./src/h_java/Exercises/FilesUsing/download_automation-co-il.html"; // give relative or full path (in this case (./) it will be under project root = C:\Users\USER\eclipse-workspace\JavaCourses)
			File file = new File(fileName);

			if (!file.exists()) { // if not exist - create new
				file.createNewFile();
			}

			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) { // go over line file that read
				bw.write(inputLine); // put each line to file written
			}

			bw.close();
			br.close();

			System.out.println("Done");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */
	// 

}
