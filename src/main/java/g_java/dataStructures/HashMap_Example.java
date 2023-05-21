package g_java.dataStructures;
// Import the HashMap class
import java.util.HashMap;
public class HashMap_Example {
	/** Create a HashMap object called people that will store String keys and Integer values
		keys and values can be any kind of object (Integer object is int wrapped in methods)
	 */
	public static void main(String[] args) {

		// Create a HashMap object called people holding <String, Integer> as Key\Value
		HashMap<String, Integer> people = new HashMap<String, Integer>();

		// Add keys and values (Name, Age) using .put
		people.put("John", 32);
		people.put("Steve", 30);
		people.put("Angie", 33);

		// print cell value using .get by key
		System.out.println("John age is: " + people.get("John"));

		// print all list
		System.out.println("ArrayList values : " + people);

		// print using loop going over all cells
		for (String i : people.keySet()) {
			System.out.println("key: " + i + " value: " + people.get(i));
		}
	}
}
