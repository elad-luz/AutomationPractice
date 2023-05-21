package h_java.exercises.filesUsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercise2_ReadLocalTxtFile {

	public static void main(String[] args) {
		System.out.println("Exercise:\n=========\n");
		
		/** notes: read text file in java example
			program that with & on a local .txt file...
			code taken from Internet => needs importing
			https://mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
		 */
		// X
        StringBuilder sb = new StringBuilder();

        // path => start in this case (./) will be under project root = C:\Users\USER\eclipse-workspace\JavaCourses
        try (BufferedReader br = Files.newBufferedReader(Paths.get("./src/h_java/Exercises/FilesUsing/testFile.txt"))) {

            // read line by line (loop over all lines)
            String line;
            while ((line = br.readLine()) != null) {
            	if (line.toLowerCase().contains("elad")) { // only limes with "elad" (regardless of case sensitive)
            		sb.append(line).append("\n"); // add to be printed
				}
                // sb.append(line).append("\n"); // without the 'if' all will be printed
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        System.out.println(sb);
		
		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */
	// 

}
